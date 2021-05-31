package com.fxc;

import com.fxc.pojo.User;
import com.fxc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroSpringbootApplicationTests {

    @Autowired
    UserService userService;
    @Test
    void contextLoads() {

        User user = userService.queryUserByUsername("fxc");
        System.out.println(user);

    }

}
