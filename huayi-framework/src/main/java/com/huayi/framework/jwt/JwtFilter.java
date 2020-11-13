package com.huayi.framework.jwt;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.web.filter.AccessControlFilter;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///*
// * 自定义一个Filter，用来拦截所有的请求判断是否携带Token
// * isAccessAllowed()判断是否携带了有效的JwtToken
// * onAccessDenied()是没有携带JwtToken的时候进行账号密码登录，登录成功允许访问，登录失败拒绝访问
// * */
//@Slf4j
//public class JwtFilter extends AccessControlFilter {
//    /*
//     * 1. 返回true，shiro就直接允许访问url
//     * 2. 返回false，shiro才会根据onAccessDenied的方法的返回值决定是否允许访问url
//     * */
//    @Override
//    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
//        log.warn("isAccessAllowed 方法被调用");
//        //这里先让它始终返回false来使用onAccessDenied()方法
//        return false;
//    }
//
//    /**
//     * 返回结果为true表明登录通过
//     */
//    @Override
//    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
//        log.warn("onAccessDenied 方法被调用");
//        //这个地方和前端约定，要求前端将jwtToken放在请求的Header部分
//
//        //所以以后发起请求的时候就需要在Header中放一个Authorization，值就是对应的Token
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        String jwt = request.getHeader("Authorization");
//        log.info("请求的 Header 中藏有 jwtToken {}", jwt);
//        JwtToken jwtToken = new JwtToken(jwt);
//        /*
//         * 下面就是固定写法
//         * */
//        try {
//            // 委托 realm 进行登录认证
//            //所以这个地方最终还是调用JwtRealm进行的认证
//            getSubject(servletRequest, servletResponse).login(jwtToken);
//            //也就是subject.login(token)
//        } catch (Exception e) {
//            e.printStackTrace();
//            onLoginFail(servletResponse);
//            //调用下面的方法向客户端返回错误信息
//            return false;
//        }
//
//        return true;
//        //执行方法中没有抛出异常就表示登录成功
//    }
//
//    //登录失败时默认返回 401 状态码
//    private void onLoginFail(ServletResponse response) throws IOException {
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        httpResponse.getWriter().write("login error");
//    }
//}

import com.huayi.common.constant.Constants;
import com.huayi.framework.cache.RedisUtil;
import com.huayi.framework.cache.ShardedRedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class JwtFilter extends BasicHttpAuthenticationFilter {

    private AntPathMatcher antPathMatcher =new AntPathMatcher();
    /**
     * 执行登录认证(判断请求头是否带上token)
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        log.info("JwtFilter-->>>isAccessAllowed-Method:init()");
        //如果请求头不存在token,则可能是执行登陆操作或是游客状态访问,直接返回true
        if (isLoginAttempt(request, response)) {
            return true;
        }
        //如果存在,则进入executeLogin方法执行登入,检查token 是否正确
        try {
            executeLogin(request, response);return true;
        } catch (Exception e) {
            throw new AuthenticationException("Token失效请重新登录");
        }
    }

    /**
     * 判断用户是否是登入,检测headers里是否包含token字段
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        log.info("JwtFilter-->>>isLoginAttempt-Method:init()");
        HttpServletRequest req = (HttpServletRequest) request;
        if(antPathMatcher.match(this.getLoginUrl(),req.getRequestURI())){
            return true;
        }
        String token = req.getHeader(Constants.ACCESS_TOKEN);
        if (token == null) {
            return false;
        }
        Object o = ShardedRedisUtil.get(Constants.PREFIX_USER_TOKEN + token);
        if(ObjectUtils.isEmpty(o)){
            return false;
        }
        log.info("JwtFilter-->>>isLoginAttempt-Method:返回true");
        return true;
    }

    /**
     * 重写AuthenticatingFilter的executeLogin方法丶执行登陆操作
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        log.info("JwtFilter-->>>executeLogin-Method:init()");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(Constants.ACCESS_TOKEN);//Access-Token
        JwtToken jwtToken = new JwtToken(token);
        // 提交给realm进行登入,如果错误他会抛出异常并被捕获, 反之则代表登入成功,返回true
        getSubject(request, response).login(jwtToken);return true;
    }

    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        log.info("JwtFilter-->>>preHandle-Method:init()");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
}
