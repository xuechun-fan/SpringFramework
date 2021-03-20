package com.fxc.test;

import com.fxc.entity.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringStaticFactory {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-static-factory.xml");
        Car car = (Car)context.getBean("car");
        System.out.println(car);

    }
}
