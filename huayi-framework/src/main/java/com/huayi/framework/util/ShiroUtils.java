package com.huayi.framework.util;

import com.huayi.common.constant.Constants;
import com.huayi.common.utils.ServletUtils;
import com.huayi.common.utils.spring.SpringUtils;
import com.huayi.framework.jwt.JwtUtil;
import com.huayi.framework.shiro.realm.MyShiroRealm;
import com.huayi.system.service.ISysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import com.huayi.common.utils.StringUtils;
import com.huayi.common.utils.bean.BeanUtils;
import com.huayi.system.domain.SysUser;

import javax.servlet.http.HttpServletRequest;

/**
 * shiro 工具类
 * 
 * @author huayi
 */
public class ShiroUtils
{
    public static Subject getSubject()
    {
        return SecurityUtils.getSubject();
    }


    public static void logout()
    {
        getSubject().logout();
    }

    public static SysUser getSysUser()
    {
        SysUser user = null;
        Object obj = getSubject().getPrincipal();
        if (StringUtils.isNotNull(obj))
        {
            user = new SysUser();
            BeanUtils.copyBeanProp(user, obj);
        }
        return user;
    }

    public static SysUser getSysUser(HttpServletRequest request)
    {
        if(request==null) {
            request = ServletUtils.getRequest();
        }
        String token = request.getHeader(Constants.ACCESS_TOKEN);//Access-Token
        String loginName = JwtUtil.getUsername(token);
        ISysUserService sysUserService = SpringUtils.getBean("sysUserService");
        SysUser sysUser = sysUserService.selectUserByLoginName(loginName);
        SysUser user = null;
        if (StringUtils.isNotNull(sysUser))
        {
            user = new SysUser();
            BeanUtils.copyBeanProp(user, sysUser);
        }
        return user;
    }

    public static void setSysUser(SysUser user)
    {
        Subject subject = getSubject();
        PrincipalCollection principalCollection = subject.getPrincipals();
        String realmName = principalCollection.getRealmNames().iterator().next();
        PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(user, realmName);
        // 重新加载Principal
        subject.runAs(newPrincipalCollection);
    }

    public static void clearCachedAuthorizationInfo()
    {
        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        MyShiroRealm realm = (MyShiroRealm) rsm.getRealms().iterator().next();
        realm.clearCachedAuthorizationInfo();
    }

    public static Long getUserId()
    {
        return getSysUser().getUserId().longValue();
    }

    public static String getLoginName()
    {
        return getSysUser().getLoginName();
    }


    /**
     * 生成随机盐
     */
    public static String randomSalt()
    {
        // 一个Byte占两个字节，此处生成的3字节，字符串长度为6
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String hex = secureRandom.nextBytes(3).toHex();
        return hex;
    }
}
