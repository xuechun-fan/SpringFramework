package com.fxc.controller;

import com.fxc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description：
 */
@Controller
@RequestMapping("/hello")
public class HelloHandler {
    @RequestMapping("/index")
    public String index(){
        System.out.println("执行了index...");
        return "index";
    }

    @RequestMapping(value="/getParams", method = RequestMethod.POST, params = {"name", "id"})
    public String getNameAndId(String name, Integer id){
        System.out.println("执行了getNameAndId（）。。。");
        System.out.println(name);
        System.out.println(id);
        return "index";
    }

    @RequestMapping(value = "/rest/{name}/{id}")
    public String testRest(@PathVariable("name") String str, @PathVariable("id") Integer num){
        System.out.println("执行了rest（）....");
        System.out.println(str);
        System.out.println(num);
        return "index";
    }

    @RequestMapping("/cookie")
    public String getCookie(@CookieValue(value = "JSESSIONID") String sessionId){
        System.out.println("执行了 getCookie");
        System.out.println(sessionId);
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(User user){
        System.out.println("执行了save() 方法");
        System.out.println(user);
        return "index";
    }

    @RequestMapping("/forward")
    public String forward(){
        return "forward:/forwardTest.jsp";    //  转发
    }

    @RequestMapping("/redirect")
    public String redirect(){
        return "redirect:/redirectTest.jsp";   //  重定向
    }

}
