package com.fxc.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {

    //  接口： http://localhost:8080/hello/index
    @RequestMapping("/index")
    public String helloIndex(){
        return "index page!!!";
    }
}
