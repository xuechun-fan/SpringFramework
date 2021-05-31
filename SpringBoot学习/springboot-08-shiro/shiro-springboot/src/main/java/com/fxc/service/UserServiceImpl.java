package com.fxc.service;

import com.fxc.mapper.UserMapper;
import com.fxc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    public User queryUserByUsername(String username) {
        return userMapper.queryUserByUsername(username);
    }
}