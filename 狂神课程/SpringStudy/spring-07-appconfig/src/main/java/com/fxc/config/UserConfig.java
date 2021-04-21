package com.fxc.config;

import com.fxc.pojo.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration  //这个也会被Spring容器托管，注册到容器中，因为他内部也是一个@Component
                //@Configuration代表这是一个配置类，就和我们之前看的beans.xml一样
@ComponentScan("com.fxc.pojo")
@Import(UserConfig2.class)      //  对应于 import 标签
public class UserConfig {
    //  注册一个bean，就相当于xml配置文件中的<bean>标签
    //  方法名---》id
    //  返回值---》标签class
    @Bean
    public User user(){
        return new User();
    }
}