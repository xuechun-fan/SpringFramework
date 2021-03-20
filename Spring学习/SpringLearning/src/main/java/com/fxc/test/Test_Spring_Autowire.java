package com.fxc.test;

import com.fxc.entity.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Spring_Autowire {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-autowire.xml");
        Person person1 = (Person) context.getBean("person1");
        System.out.println(person1);
//        Person person2 = (Person) context.getBean("person2");
//        System.out.println(person2);
    }
}
