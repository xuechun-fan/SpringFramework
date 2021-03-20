package com.fxc.test;

import com.fxc.entity.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test01 {
    public static void main(String[] args) {
        //  加载MyBatis配置文件
        InputStream inputStream = Test01.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession session = factory.openSession();
        String statement = "com.fxc.mapper.AccountMapper.save";
        Account account = new Account(1, "张三", "123123", 19, null);
        session.insert(statement, account);
        session.commit();
        session.close();
    }
}
