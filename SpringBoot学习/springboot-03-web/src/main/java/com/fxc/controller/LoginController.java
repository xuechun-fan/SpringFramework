package com.fxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * 登录控制器
 *
 * @author FXC
 */
@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, Model model,
                        HttpSession session) {
        //  具体的业务
        if (!StringUtils.hasText(username) && "123".equals(password)) {
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        } else {
            //  告诉用户，你登陆失败了
            model.addAttribute("msg", "用户名或者密码错误！");
            return "index";
        }
    }
}