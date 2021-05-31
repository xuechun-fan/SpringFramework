package com.fxc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.print.Doc;
import java.util.ArrayList;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //  配置了Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){

        //  设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev");

        //  获取项目的环境
        boolean isDev = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(isDev)   //  是否启用swagger
                .select()
                //  RequestHandlerSelectors,配置要扫描接口的方式
                //  basePackage:指定要扫描的包
                //  any():扫描全部
                //  none():不扫描
                //  withClassAnnotation：扫描类上的注解，参数是一个注解的反射对象
                //  withMethodAnnotation：扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.fxc.controller"))
                //  过滤什么路径
                //.paths(PathSelectors.ant("/fxc/**"))
                .build()
                ;
    }
    private ApiInfo apiInfo(){

        //  作者信息
        Contact contact = new Contact("范学春", "http:localhost:8080", "1570285527@qq.com");

        ApiInfo apiInfo = new ApiInfo(
                "学春的SwaggerApi文档",
                "努力学习技术",
                "1.0",
                "http://localhost:8080",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses.LICENSE-2.0",
                new ArrayList<>()
        );
        return apiInfo;
    }

    //  分组
    @Bean
    public Docket docket1(){
        Contact contact = new Contact("张三", "http:localhost:8080", "zhangsan@163.com");
        ApiInfo apiInfo = new ApiInfo("张三的SwaggerApi文档",
                "张三也是咬学习技术",
                "1.0",
                "http://localhost:8080",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses.LICENSE-2.0",
                new ArrayList<>());

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("张三")
                .apiInfo(apiInfo);
    }
}