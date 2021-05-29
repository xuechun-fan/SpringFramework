package com.fxc.controller;

import com.fxc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    //  只要我们的接口中返回值中存在实体类，他就会呗扫描到Swagger中
    @PostMapping("/user")
    public User user(){
        return new User();
    }
}