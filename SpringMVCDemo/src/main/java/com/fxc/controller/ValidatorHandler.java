package com.fxc.controller;

import com.fxc.entities.Account;
import com.fxc.entities.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Description：
 */
@Controller
@RequestMapping("/validator")
public class ValidatorHandler {

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("account", new Account());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Validated Account account, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "login";
        }
        return "index";
    }



    //  使用JSR303标准，需要在springmvc.xml配置文件中，单独再配置一次mvc注解驱动
    //  <mvc:annotation-driven></mvc:annotation-driven>
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("person", new Person());
        return "JSR303";
    }

    @PostMapping("/register")
    public String register(@Valid Person person, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "JSR303";
        }
        return "index";
    }
}
