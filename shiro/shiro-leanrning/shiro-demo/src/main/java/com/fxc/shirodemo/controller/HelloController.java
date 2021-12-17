package com.fxc.shirodemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author FXC
 */
@Controller
public class HelloController {

    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello shiro";
    }
}