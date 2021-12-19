package com.fxc.shirodemo.realms;

import com.fxc.shirodemo.domain.UserDO;
import com.fxc.shirodemo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 自定义Realm继承自AuthenticatingRealm，实现认证功能
 *
 * @author FXC
 */
@Component
public class MyRealm01 extends AuthenticatingRealm {

    /** 注入用户服务 */
    @Autowired
    private UserService userService;

    /**
     * 核心方法
     * 根据用户输入的用户名去DB中查询用户信息并返回
     *
     * @param token 该参数包含了用户登陆时输入的用户名和密码信息
     * @return 返回从DB中查询到的用户信息
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 将传入token强转UsernamePasswordToken类型
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        // 获取用户登录时的用户名
        String username = usernamePasswordToken.getUsername();
        UserDO userFromDb = userService.selectUserByName(username);
        if (userFromDb == null) {
            // 说明用户登录时用户名不存在
            throw new UnknownAccountException("用户名不存在...");
        }
        // 返回从DB中查询到的信息
        return new SimpleAuthenticationInfo(userFromDb.getUsername(), userFromDb.getPassword(), ByteSource.Util
                .bytes(userFromDb.getUsername()), getName());
    }

    @Override
    public CredentialsMatcher getCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("md5");
        matcher.setHashIterations(1024);
        return matcher;
    }

}