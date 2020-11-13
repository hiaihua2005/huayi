package com.huayi.web.controller.system;

import com.huayi.common.constant.Constants;
import com.huayi.common.json.JSONObject;
import com.huayi.framework.cache.ShardedRedisPool;
import com.huayi.framework.cache.ShardedRedisUtil;
import com.huayi.framework.jwt.JwtUtil;
import com.huayi.framework.shiro.service.SysLoginService;
import com.huayi.framework.web.base.BaseController;
import com.huayi.system.domain.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录验证
 * 
 * @author huayi
 */
@Controller
public class SysLoginController extends BaseController
{

    @Autowired
    SysLoginService sysLoginService;


    @PostMapping("/biz/user/login")
    @ResponseBody
    public AjaxResult ajaxLogin(String username, String password) {
       if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
           return error("请输入登录信息");
       }
        SysUser user=sysLoginService.login(username,password);
        if (user == null) {
            return error("该用户不存在");
        }
        if (user.getStatus()=="0") {
            return error("账号已被禁用,请联系管理员!");
        }
        // 生成token
        String token = JwtUtil.sign(username, password);
        ShardedRedisUtil.set(Constants.PREFIX_USER_TOKEN + token, token,JwtUtil.EXPIRE_TIME / 1000);
        JSONObject obj = new JSONObject();
        obj.put("token", token);
        obj.put("userInfo", user);
        return AjaxResult.success("登录成功",obj);

//        Boolean rememberMe = false;
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
//        Subject subject = SecurityUtils.getSubject();
//        try
//        {
//            subject.login(token);
//            return success();
//        }
//        catch (AuthenticationException e)
//        {
//            String msg = "用户或密码错误";
//            if (StringUtils.isNotEmpty(e.getMessage()))
//            {
//                msg = e.getMessage();
//            }
//            return error(msg);
//        }
    }

}
