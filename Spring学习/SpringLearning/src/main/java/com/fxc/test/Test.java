package com.fxc.test;

import com.fxc.entity.Student;
import com.fxc.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //  加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User user1 = (User) context.getBean("user1");
        User user2 = (User) context.getBean("user2");
//        System.out.println(user1==user2);
        System.out.println(user1);
        System.out.println(user2);
        Student student = (Student) context.getBean("stu");
        System.out.println(student);
    }
}
