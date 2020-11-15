package com.huayi.web.controller.system;

import com.huayi.common.constant.Constants;
import com.huayi.common.constant.UserConstants;
import com.huayi.common.json.JSONObject;
import com.huayi.framework.beans.LoginUser;
import com.huayi.framework.cache.ShardedRedisPool;
import com.huayi.framework.cache.ShardedRedisUtil;
import com.huayi.framework.jwt.JwtUtil;
import com.huayi.framework.shiro.service.SysLoginService;
import com.huayi.framework.util.ShiroUtils;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
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
    public AjaxResult ajaxLogin(@RequestBody LoginUser loginUser) {
       if(StringUtils.isEmpty(loginUser.getUsername()) || StringUtils.isEmpty(loginUser.getPassword())) {
           return error("请输入登录信息");
       }
        SysUser user=sysLoginService.login(loginUser.getUsername(),loginUser.getPassword());
        if (user == null) {
            return error("该用户不存在");
        }
        if (user.getStatus()== UserConstants.USER_BLOCKED) {
            return error("账号已被禁用,请联系管理员!");
        }
        // 生成token
        String token = JwtUtil.sign(loginUser.getUsername(),loginUser.getPassword());
        ShardedRedisUtil.set(Constants.PREFIX_USER_TOKEN + token, token,JwtUtil.EXPIRE_TIME / 1000);
        JSONObject obj = new JSONObject();
        obj.put("token", token);
        obj.put("userInfo", user);
        return AjaxResult.success("登录成功",obj);
    }


    @PostMapping("/biz/user/auth")
    @ResponseBody
    public AjaxResult ajaxAuth(HttpServletRequest request) {
        SysUser user = ShiroUtils.getSysUser(request);
        return success(user);
    }

}
