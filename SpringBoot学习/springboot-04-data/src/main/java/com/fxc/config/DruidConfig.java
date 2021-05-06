package com.fxc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //  后台监控功能:web.xml, ServletRegistrationBean
    //  因为SpringBoot 内置了 servlet 容器，所以没有 web.xml， 替代方法：ServletRegistrationBean注册进去 @Bean
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //  后台需要有人登录，账号密码配置
        HashMap<String, String> initParameters = new HashMap<>();
        //  增加配置
        initParameters.put("loginUsername", "root");    //  登录key是固定的
        initParameters.put("loginPassword", "333");
        //  允许谁可以访问，即权限配置
        initParameters.put("allow", "localhost");
        //  禁止谁不可以访问
//        initParameters.put("fxc", "ip地址");
        bean.setInitParameters(initParameters);   //  设置初始化参数
        return bean;
    }


    //  拦截器
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new WebStatFilter());
        //  可以过滤哪些请求呢
        Map<String, String> initialParameters = new HashMap<>();
        //  这些东西不进行统计
        initialParameters.put("exclusions", "*.js, *.css, /druid/*");
        bean.setInitParameters(initialParameters);
        return bean;
    }

}