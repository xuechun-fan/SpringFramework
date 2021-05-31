package com.fxc.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {
    @RequestMapping({"/", "index"})
    public String index(){
        return "index";
    }


    @RequestMapping("/toLogin")
    public String toLogin(){
        return "views/login";
    }

    @RequestMapping("/level1/{id}")
    public String leve1(@PathVariable("id") Integer id){
        return "views/level1/" + id;
    }

    @RequestMapping("/level2/{id}")
    public String leve2(@PathVariable("id") Integer id){
        return "views/level2/" + id;
    }

    @RequestMapping("/level3/{id}")
    public String leve3(@PathVariable("id") Integer id){
        return "views/level3/" + id;
    }
}