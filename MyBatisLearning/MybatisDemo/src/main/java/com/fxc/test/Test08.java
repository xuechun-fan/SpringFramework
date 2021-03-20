package com.fxc.test;

import com.fxc.entity.Account;
import com.fxc.repository.AccountRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Test08 {
    public static void main(String[] args) {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Test08.class.getClassLoader().getResourceAsStream("config.xml"));
        SqlSession session = factory.openSession();
        Account account = new Account();
//        account.setId(1);
//        account.setUsername("张三");
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        account.setIds(ids);
        AccountRepository proxy = session.getMapper(AccountRepository.class);
        System.out.println(proxy.findByIds(account));
        session.close();
    }
}
