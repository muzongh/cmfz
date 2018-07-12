package com.baizhi.cmfz.utils;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.ManagerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;

import java.util.List;
import java.util.UUID;

/**
 * @Description TODO
 * @Author Muzonghao
 * @Date 2018/7/11 20:55
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private ManagerService ms;
    /**
     * 获取授权信息 角色权限+权限信息
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        List<Role> roles = ms.queryRolesByName(username);
        for (Role role : roles) {
            info.addRole(role.getRoleTag());
        }
        List<Permission> permissions = ms.queryPermissionsByName(username);
        for (Permission permission : permissions) {
            System.out.println(permission);
            info.addStringPermission(permission.getPermissionTag());
        }
        return info;
    }

    /**
     * 获取认证信息方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;

        String username = usernamePasswordToken.getUsername();

        Manager manager = ms.login(username);

        if(manager!=null) {
            return new SimpleAuthenticationInfo(username,
                    manager.getManagerPassword(),
                    ByteSource.Util.bytes(manager.getManagerSalt()),
                    UUID.randomUUID().toString());
        }
        return null;
    }
}
