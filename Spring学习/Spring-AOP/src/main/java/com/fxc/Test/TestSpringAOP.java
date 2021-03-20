package com.fxc.Test;

import com.fxc.impl.ShowInfo;
import com.fxc.utils.Cal;
import com.fxc.utils.Show;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringAOP {
    public static void main(String[] args) {
        //  加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        //  获取代理对象
        Cal proxy = (Cal)context.getBean("calImpl");
        proxy.add(10, 2);
        proxy.sub(10, 2);
        proxy.mul(10, 2);
        proxy.div(10, 2);
        System.out.println("------------------------");
        Show showInfo = (Show)context.getBean("showInfo");
        showInfo.show(1, 2);
        System.out.println("------------------------");
    }
}
