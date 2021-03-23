package com.fxc.controller;

import com.fxc.entities.Address;
import com.fxc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.jws.WebParam;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Description：
 */
@Controller
@RequestMapping("/view")
//@SessionAttributes(types = {User.class, Address.class})
public class ViewHandler {
    @RequestMapping("/map")
    public String map(Map<String, User> map){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        map.put("user", user);
        return "view";
    }

    @RequestMapping("/model")
    public String model(Model model){
        User user = new User();
        user.setId(1);
        user.setName("李四");
        model.addAttribute(user);
        return "view";
    }

    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView(){
        User user = new User();
        user.setId(1);
        user.setName("李四");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("view");
        return modelAndView;
    }

    @RequestMapping("/modelAndView2")
    public ModelAndView modelAndView2(){
        User user = new User();
        user.setId(2);
        user.setName("李四");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        View view = new InternalResourceView("/view.jsp");
        modelAndView.setView(view);
        return modelAndView;
    }

    @RequestMapping("/modelAndView3")
    public ModelAndView modelAndView3(){
        User user = new User();
        user.setId(3);
        user.setName("李四");
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("/modelAndView4")
    public ModelAndView modelAndView4(){
        User user = new User();
        user.setId(4);
        user.setName("李四");
        View view = new InternalResourceView("/view.jsp");
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("/modelAndView5")
    public ModelAndView modelAndView5(){
        User user = new User();
        user.setId(5);
        user.setName("李四");
        Map<String, User> map = new HashMap<>();
        map.put("user", user);
        ModelAndView modelAndView = new ModelAndView("view", map);
        return modelAndView;
    }

    @RequestMapping("/modelAndView6")
    public ModelAndView modelAndView6(){
        User user = new User();
        user.setId(6);
        user.setName("李四");
        Map<String, User> map = new HashMap<>();
        map.put("user", user);
        View view = new InternalResourceView("/view.jsp");
        ModelAndView modelAndView = new ModelAndView(view, map);
        return modelAndView;
    }

    @RequestMapping("/modelAndView7")
    public ModelAndView modelAndView7(){
        User user = new User();
        user.setId(7);
        user.setName("六四");
        ModelAndView modelAndView = new ModelAndView("view","user", user);
        return modelAndView;
    }

    @RequestMapping("modelAndView8")
    public ModelAndView modelAndView8(){
        User user = new User();
        user.setId(8);
        user.setName("梨花");
        View view = new InternalResourceView("/view.jsp");
        ModelAndView modelAndView = new ModelAndView(view, "user", user);
        return modelAndView;
    }

    //  原生方式
    @RequestMapping("request")
    public String request(HttpServletRequest request){
        User user = new User();
        user.setId(11);
        user.setName("reques");
        request.setAttribute("user", user);
        return "view";
    }


    //  @ModelAttribute注解修饰的方法会先于业务方法执行，也就是说public String modelAttribute()方法执行前，
    //  模型已经存在了
//    @ModelAttribute
//    public User getUser(){
//        User user = new User();
//        user.setId(11);
//        user.setName("ModelAttribute");
//        return user;
//    }

//    @ModelAttribute
//    public void getUser(Map<String, User> map){
//        User user = new User();
//        user.setId(11);
//        user.setName("ModelAttribute-Map");
//        map.put("user", user);
//    }

//    @ModelAttribute
    public void getUser(Model model){
        User user = new User();
        user.setId(11);
        user.setName("ModelAttribute-Model");
        model.addAttribute("user", user);
    }

    @RequestMapping("/modelAttribute")
    public String modelAttribute(){
        return "view";
    }


    @RequestMapping("/session")
    public String session(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = new User();
        user.setId(11);
        user.setName("Session");
        session.setAttribute("user", user);
        return "view";
    }

    @RequestMapping("/seesion2")
    public String session2(HttpSession session){
        User user = new User();
        user.setId(21);
        user.setName("Session2");
        session.setAttribute("user", user);
        return "view";
    }

    //  将模型数据绑定到 application 对象
    @RequestMapping("/application")
    public String application(HttpServletRequest request){
        ServletContext application = request.getServletContext();
        User user = new User();
        user.setId(12);
        user.setName("奥特曼");
        application.setAttribute("user", user);
        return "view";
    }


}
