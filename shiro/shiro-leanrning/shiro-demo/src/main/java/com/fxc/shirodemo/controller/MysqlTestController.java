package com.fxc.shirodemo.controller;

import com.fxc.shirodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Mybatis整合功能
 *
 * @author FXC  2021年12月19日 2:46
 */
@RestController
public class MysqlTestController {

    /** 用户Dao */
    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public String get(Integer id) {
        if (id == null) {
            return "请检查输入ID, 不可为空!";
        }
        return userService.selectUserById(id).toString();
    }
}
