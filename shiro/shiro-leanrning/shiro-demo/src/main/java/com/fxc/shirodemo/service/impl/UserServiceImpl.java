package com.fxc.shirodemo.service.impl;

import com.fxc.shirodemo.dao.UserDao;
import com.fxc.shirodemo.domain.UserDO;
import com.fxc.shirodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 *
 * @author FXC  2021年12月19日 22:15
 */
@Service
public class UserServiceImpl implements UserService {

    /** 注入UserDao服务 */
    @Autowired
    private UserDao userDao;

    public UserDO selectUserByName(String username) {
        return userDao.selectUserByName(username);
    }
}
