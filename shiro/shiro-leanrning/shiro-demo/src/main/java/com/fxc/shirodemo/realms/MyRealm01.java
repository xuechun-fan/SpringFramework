package com.fxc.shirodemo.realms;

import com.fxc.shirodemo.domain.UserDO;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义Realm继承自AuthenticatingRealm，实现认证功能
 *
 * @author FXC
 */
public class MyRealm01 extends AuthenticatingRealm {

    /** 模拟DB存储用户数据 */
    private final Map<String, UserDO> cache = new HashMap<String, UserDO>(8);

    public MyRealm01() {
        cache.put("zhangsan", new UserDO(1, "zhangsan", "123"));
        cache.put("lisi", new UserDO(1, "lisi", "123"));
    }

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
        UserDO userFromDb = getUserFromDb(username);
        if (userFromDb == null) {
            // 说明用户登录时用户名不存在
            throw new UnknownAccountException("用户名不存在...");
        }
        // 返回从DB中查询到的信息
        return new SimpleAuthenticationInfo(userFromDb.getUserName(), userFromDb.getPassword(),
                                            getName());
    }

    /**
     * 模拟从数据库中查询用户信息
     *
     * @param userName
     * @return
     */
    private UserDO getUserFromDb(String userName) {
        if (StringUtils.isEmpty(userName)) {
            return null;
        }
        return cache.get(userName);
    }
}