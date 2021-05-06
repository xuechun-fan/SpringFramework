package com.fxc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.fxc.mapper")
public class Spring05MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring05MybatisApplication.class, args);
    }

}
