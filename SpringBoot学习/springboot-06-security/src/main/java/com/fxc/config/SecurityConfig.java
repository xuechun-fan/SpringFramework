package com.fxc.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //  链式编程
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //  首页所有人可以访问， 功能页只有对应权限的人才能访问
        //  请求授权的规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        //  没有权限，默认跳转登陆页面
        http.formLogin().loginPage("/toLogin")
                .usernameParameter("user")
                .passwordParameter("pwd")
                .successForwardUrl("/index")
                .failureForwardUrl("/toLogin");


        //  关闭csrf功能    防止跨站攻击工具： get post
        http.csrf().disable();

        //  注销
        http.logout().deleteCookies().logoutSuccessUrl("/index");

        //  开启记住我功能，默认保存两周
        http.rememberMe().rememberMeParameter("remember");
    }

    //  认证，   springboot 2.1.X  可以直接使用
    //  较新的版本需要注意密码编码问题 PasswordEncoder
    //  在Spring Security 5.0+ 版本 新增了很多加密的方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        //  这些数据正常应该从数据库中读
        auth.inMemoryAuthentication().passwordEncoder(encoder)
                .withUser("fxc").password(encoder.encode("123")).roles("vip2", "vip3")
                .and()
                .withUser("root").password(encoder.encode("123")).roles("vip1", "vip2", "vip3")
                .and()
                .withUser("guest").password(encoder.encode("123")).roles("vip1");
    }
}