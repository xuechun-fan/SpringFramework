package com.fxc.shirodemo.controller;

import com.fxc.shirodemo.dao.UserDao;
import com.fxc.shirodemo.domain.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Mybatis整合
 *
 * @author FXC  2021年12月19日 21:58
 */
@RestController
public class MybatisTestController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/get")
    public String get() {
        UserDO userDO = userDao.selectUserByName("zhangsan");
        if (userDO == null) {
            return "未查到记录";
        }
        return userDO.toString();
    }
}
