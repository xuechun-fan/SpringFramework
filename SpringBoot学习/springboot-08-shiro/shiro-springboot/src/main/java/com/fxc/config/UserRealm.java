package com.fxc.config;

import com.fxc.pojo.User;
import com.fxc.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //  授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了-》授权doGetAuthorizationInfo");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //  获取当前用户
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();
        System.out.println("====================================="+currentUser.getPerm());

        //  设置当前用户权限
        info.addStringPermission(currentUser.getPerm()==null ? "default" :currentUser.getPerm());
        return info;
    }

    //  认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了-》认证doGetAuthenticationInfo");

        //  封装用户的登录数据
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        //  从数据库中取数据
        User user = userService.queryUserByUsername(userToken.getUsername());

        if(user==null){
            return null;    //  抛出异常 UnknownAccountException
        }

//        Subject subject = SecurityUtils.getSubject();
//        Session session = subject.getSession();
//        session.setAttribute("loginUser", user);

        //  密码认证， shiro做,  shiro加密了
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");

    }
}