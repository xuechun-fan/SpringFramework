package com.fxc.service;


import com.fxc.pojo.User;

public interface UserService {
    public User queryUserByUsername(String username);
}