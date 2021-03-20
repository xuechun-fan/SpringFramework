package com.fxc.test;

import com.fxc.entity.Student;
import com.fxc.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jws.soap.SOAPBinding;

public class Test2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-denpends.xml");
//        Student student = (Student) context.getBean("student");
//        User user = (User) context.getBean("user");

    }
}
