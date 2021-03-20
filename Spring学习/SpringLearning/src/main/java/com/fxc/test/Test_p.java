package com.fxc.test;

import com.fxc.entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_p {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-p.xml");
        User user = (User) context.getBean("user");
        System.out.println(user);
    }
}
