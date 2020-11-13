package com.huayi.framework.jwt;


import com.huayi.common.constant.Constants;
import com.huayi.framework.cache.ShardedRedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
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
        if (((HttpServletRequest) request).getMethod().toUpperCase().equals("OPTIONS")) {
            return true;
        }
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

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //这几句代码是关键
        if ("OPTIONS".equals(request.getMethod())){
            response.setStatus(org.apache.http.HttpStatus.SC_NO_CONTENT);;
            log.info("OPTIONS 放行");
            return true;
        }
        try {
            return super.onAccessDenied(servletRequest, servletResponse);
        }catch (Exception e) {
            return false;
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
//        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
//        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
//        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
//        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
//        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
//            httpServletResponse.setStatus(HttpStatus.OK.value());
//            return false;
//        }
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*"); // 设置允许所有跨域访问
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,OPTIONS,DELETE");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept,Authorization,token");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }

        return super.preHandle(request, response);
    }
}
