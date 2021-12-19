package com.fxc.shirodemo.service.impl;

import com.fxc.shirodemo.dao.UserDao;
import com.fxc.shirodemo.domain.UserDO;
import com.fxc.shirodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 *
 * @author FXC  2021年12月19日 2:51
 */
@Service
public class UserServiceImpl implements UserService {

    /** 用户Dao服务 */
    @Autowired
    private UserDao userDao;

    public UserDO selectUserById(Integer id) {
        if (id == null) {
            return null;
        }
        return userDao.selectUserById(id);
    }
}
