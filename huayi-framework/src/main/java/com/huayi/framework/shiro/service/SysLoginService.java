package com.huayi.framework.shiro.service;

import com.huayi.common.utils.IpUtils;
import com.huayi.framework.manager.AsyncManager;
import com.huayi.framework.manager.factory.AsyncFactory;
import com.huayi.framework.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.huayi.common.constant.Constants;
import com.huayi.common.constant.ShiroConstants;
import com.huayi.common.constant.UserConstants;
import com.huayi.common.enums.UserStatus;
import com.huayi.common.exception.user.CaptchaException;
import com.huayi.common.exception.user.UserBlockedException;
import com.huayi.common.exception.user.UserNotExistsException;
import com.huayi.common.exception.user.UserPasswordNotMatchException;
import com.huayi.common.utils.MessageUtils;
import com.huayi.common.utils.ServletUtils;
import com.huayi.system.domain.SysUser;
import com.huayi.system.service.ISysUserService;

import java.util.List;

/**
 * 登录校验方法
 * 
 * @author huayi
 */
@Component
public class SysLoginService
{
    @Autowired
    private SysPasswordService passwordService;

    @Autowired
    private ISysUserService userService;

    /**
     * 登录
     */
    public SysUser login(String loginName, String password)
    {
        // 验证码校验
        if (!StringUtils.isEmpty(ServletUtils.getRequest().getAttribute(ShiroConstants.CURRENT_CAPTCHA)))
        {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(loginName, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.error")));
            throw new CaptchaException();
        }
        // 用户名或密码为空 错误
        if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password))
        {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(loginName, Constants.LOGIN_FAIL, MessageUtils.message("not.null")));
            throw new UserNotExistsException();
        }
        // 密码如果不在指定范围内 错误
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH)
        {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(loginName, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
            throw new UserPasswordNotMatchException();
        }

        // 用户名不在指定范围内 错误
        if (loginName.length() < UserConstants.USERNAME_MIN_LENGTH
                || loginName.length() > UserConstants.USERNAME_MAX_LENGTH)
        {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(loginName, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
            throw new UserPasswordNotMatchException();
        }

        // 查询用户信息
        SysUser user = userService.selectUserByLoginName(loginName);

        if (user == null && maybeMobilePhoneNumber(loginName))
        {
            List<SysUser> userList = userService.selectUserByPhone(loginName);
            if(userList!=null && userList.size() ==1 ) {
                user = userList.get(0);
            }
        }

        if (user == null && maybeEmail(loginName))
        {
            List<SysUser> userList = userService.selectUserByEmail(loginName);
            if(userList!=null && userList.size() ==1 ) {
                user = userList.get(0);
            }
        }
        if (user == null)
        {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(loginName, Constants.LOGIN_FAIL, MessageUtils.message("user.not.exists")));
            throw new UserNotExistsException();
        }

        
        if (UserStatus.DISABLE.getCode().equals(user.getStatus()))
        {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(loginName, Constants.LOGIN_FAIL, MessageUtils.message("user.blocked", user.getRemark())));
            throw new UserBlockedException();
        }

        passwordService.validate(user, password);

        AsyncManager.me().execute(AsyncFactory.recordLogininfor(loginName, Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
        recordLoginInfo(user);
        return user;
    }

    private boolean maybeEmail(String username)
    {
        if (!username.matches(UserConstants.EMAIL_PATTERN))
        {
            return false;
        }
        return true;
    }

    private boolean maybeMobilePhoneNumber(String username)
    {
        if (!username.matches(UserConstants.MOBILE_PHONE_NUMBER_PATTERN))
        {
            return false;
        }
        return true;
    }

    /**
     * 记录登录信息
     */
    public void recordLoginInfo(SysUser user)
    {
        String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
        user.setLoginIp(ip);
//        user.setLoginTime(DateUtils.getNowDate());
//        userService.updateSysUser(user);
    }
}
