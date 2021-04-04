package com.fxc.test;

import com.fxc.entity.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class Test01 {
    public static void main(String[] args) throws IOException {
        //  加载MyBatis配置文件
        Reader reader = Resources.getResourceAsReader("config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = factory.openSession();
        String statement = "com.fxc.mapper.AccountMapper.save";
        Account account = new Account(3, "张三", "123123", 19, null);
        session.insert(statement, account);
        session.commit();
        session.close();
    }
}
