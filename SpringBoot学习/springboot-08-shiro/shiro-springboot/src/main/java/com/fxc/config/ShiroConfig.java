package com.fxc.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //  ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(securityManager);
        //  添加shiro的内置过滤器
        /*
        * anon:无需认证就能访问
        * authc:必须认证了才能访问
        * user:必须拥有 记住我 才能访问
        * perms:拥有对某个资源的权限才能访问
        * role:拥有某个角色才能访问
        * */
        Map<String, String> filterMap = new LinkedHashMap<String, String>();

        //  认证
        filterMap.put("/user/add", "authc");
        filterMap.put("/user/update", "authc");
        //  授权
        filterMap.put("/user/add", "perms[admin]");
        filterMap.put("/user/update", "perms[customer]");

        bean.setFilterChainDefinitionMap(filterMap);


        //  设置登录页面
        bean.setLoginUrl("/toLogin");
        //  设置未授权页面
        bean.setUnauthorizedUrl("/noauth");

        return bean;
    }

    //  DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //  关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //  创建realm对象
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //  整合ShiroDialect  用来整合Shiro 和 thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}