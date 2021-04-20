package com.fxc.service;

import com.fxc.dao.UserDao;
import com.fxc.dao.UserDaoImpl;

/**
 * Description：
 */
public interface UserService{
    public void setUserDao(UserDao userDao);
    public void getUser();
}
