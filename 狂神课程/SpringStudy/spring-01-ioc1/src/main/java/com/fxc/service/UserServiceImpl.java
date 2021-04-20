package com.fxc.service;

import com.fxc.dao.UserDao;
import com.fxc.dao.UserDaoImpl;
import com.fxc.dao.UserDaoMysqlImpl;
import com.fxc.dao.UserDaoOracleImpl;

/**
 * Description：
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    //  利用setter接口来实现注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
