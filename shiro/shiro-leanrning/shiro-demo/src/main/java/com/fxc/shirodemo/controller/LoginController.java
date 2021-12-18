package com.fxc.shirodemo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录Controller
 *
 * @author FXC
 */
@RestController
public class LoginController {

    @PostMapping(value = "/doLogin", produces = "text/html;charset=utf-8")
    public String doLogin(String userName, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            // 执行登录操作
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
        } catch (AuthenticationException e) {
            return "登陆失败： " + e.getMessage();
        }
        return "success";
    }
}