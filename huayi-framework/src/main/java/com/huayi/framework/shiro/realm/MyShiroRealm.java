package com.huayi.framework.shiro.realm;

import com.google.common.base.Strings;
import com.huayi.framework.jwt.JwtToken;
import com.huayi.framework.jwt.JwtUtil;
import com.huayi.framework.shiro.service.SysLoginService;
import com.huayi.system.domain.SysUser;
import com.huayi.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Slf4j
public class MyShiroRealm extends AuthorizingRealm {
//    @Autowired
//    private RoleService roleService;
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private PermissionService permissionService;

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 访问控制。比如某个用户是否具有某个操作的使用权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        SysUser user  = (SysUser) principalCollection.getPrimaryPrincipal();if (user == null) {
            log.error("授权失败，用户信息为空！！！");
            return null;
        }
//        try {
//            //获取用户角色集
//            Set<String> listRole= roleService.findRoleByUsername(user.getUserName());
//            simpleAuthorizationInfo.addRoles(listRole);
//
//            //通过角色获取权限集
//            for (String role : listRole) {
//                Set<String> permission= permissionService.findPermissionByRole(role);
//                simpleAuthorizationInfo.addStringPermissions(permission);
//            }
//            return simpleAuthorizationInfo;
//        } catch (Exception e) {
//            log.error("授权失败，请检查系统内部错误!!!", e);
//        }
        return simpleAuthorizationInfo;
    }

    /**
     * 用户身份识别(登录")
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();// 校验token有效性
        String username = JwtUtil.getUsername(token);if (Strings.isNullOrEmpty(username)) {
            throw new AuthenticationException("token非法无效!");
        }// 查询用户信息
        SysUser sysUser = sysUserService.selectUserByLoginName(username);
        if (sysUser == null) {
            throw new AuthenticationException("用户不存在!");
        }// 判断用户状态
        if (sysUser.getStatus()=="0") {
            throw new AuthenticationException("账号已被禁用,请联系管理员!");
        }
        return new SimpleAuthenticationInfo(sysUser,token, ByteSource.Util.bytes(sysUser.getSalt()),getName());
    }

    public void clearCachedAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}