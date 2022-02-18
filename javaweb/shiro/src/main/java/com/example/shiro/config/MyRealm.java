// 2022/2/18 15:20

package com.example.shiro.config;

import com.example.shiro.pojo.User;
import com.example.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权=>AuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //拿到当前用户
        Subject subject= SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        info.addStringPermission(user.getPerms());

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了认证=>AuthenticationInfo");
        //用户名密码从数据库取

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        User user = userService.queryUserByName(userToken.getUsername());
        if (user == null) {
            return null;
        }
        //密码认证无需处理，shiro自动完成
        return new SimpleAuthenticationInfo(user, user.getPwd(), "");
    }
}
