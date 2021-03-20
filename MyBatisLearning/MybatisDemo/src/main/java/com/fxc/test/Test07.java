package com.fxc.test;

import com.fxc.entity.Account;
import com.fxc.repository.AccountRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.swing.*;
import java.io.InputStream;

/**
 * 测试 MyBatis 缓存机制
 */
public class Test07 {
    public static void main(String[] args) {
        InputStream inputStream = Test07.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession session = factory.openSession();
        AccountRepository accountRepository = session.getMapper(AccountRepository.class);
        Account account = accountRepository.findById(1);
        System.out.println(account);
        session.close();
        session = factory.openSession();
        accountRepository = session.getMapper(AccountRepository.class);
        Account account1 = accountRepository.findById(1);
        System.out.println(account1);
    }
}
