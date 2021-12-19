package com.fxc.shirodemo.service;

import com.fxc.shirodemo.domain.UserDO;

/**
 * 用户服务接口
 *
 * @author FXC  2021年12月19日 2:49
 */
public interface UserService {

    /**
     * 根据用户名查询用户数据
     *
     * @param username 用户名
     * @return 返回DB中查询到的结果
     */
    UserDO selectUserByName(String username);
}
