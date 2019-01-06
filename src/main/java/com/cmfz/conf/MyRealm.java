package com.cmfz.conf;

import com.cmfz.entity.Admin;
import com.cmfz.entity.Permission;
import com.cmfz.mapper.AdminMapper;
import com.cmfz.mapper.UserMapper;
import com.cmfz.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Administrator
 * @Title: MyRealm
 * @ProjectName cmfz
 * @Date 2019-01-06--9:34
 */
public class MyRealm extends AuthorizingRealm {
    @Resource
    private AdminMapper adminMapper;

    /**
     * 获取授权的数据
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Admin admin = adminMapper.queryAllByPermissionOfRole(primaryPrincipal);
        authorizationInfo.addRole(admin.getRole());
        List<Permission> permissions = admin.getPermissions();
        for (Permission permission : permissions) {
            authorizationInfo.addStringPermission(permission.getPermission());
        }
        return authorizationInfo;
    }

    /**
     * 获取认证的数据
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        //调用AdminMapper获取用户信息
        Admin admin = new Admin();
        admin.setName(userName);
        Admin admin1 = adminMapper.queryAllByPermissionOfRole(userName);
        if (admin1 == null) {
            throw new UnknownAccountException();
        }
        System.out.println(admin1);
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(admin1.getName(), admin1.getPassword(), ByteSource.Util.bytes(admin1.getSalt()), this.getName());
        System.out.println("ssssssssssssssss" + authenticationInfo.getCredentials());
        return authenticationInfo;


    }
}
