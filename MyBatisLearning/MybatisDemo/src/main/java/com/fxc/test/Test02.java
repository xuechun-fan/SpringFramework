package com.fxc.test;

import com.fxc.entity.Account;
import com.fxc.repository.AccountRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        InputStream inputStream = Test02.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession session = factory.openSession();
        //  获取实现接口的代理对象
        AccountRepository accountRepository = session.getMapper(AccountRepository.class);
//        //  添加对象
//        Account account = new Account(3, "王五", "123111", 12);
//        accountRepository.save(account);
//        session.commit();

//        //  根据 id 查询记录
//        Account account = accountRepository.findById(2);
//        System.out.println("--------根据id 查询---------");
//        System.out.println(account);
//        System.out.println("---------------------------");
//
//        //   修改该记录
//        account.setAge(28);
//        account.setPassword("000000");
//        accountRepository.update(account);
//        session.commit();
//
//        //  查询全部记录
//        List<Account> list = accountRepository.findAll();
//        for(Account ac : list){
//            System.out.println(ac);
//        }

//        //  根据 username 查询
//        Account account = accountRepository.findByName("王五");
//        System.out.println(account);

//        //  根据多个参数进行查询
//        Account account = accountRepository.findByNameAndAge("张三", 19);
//        System.out.println(account);

//        //  统计记录数量
//        int counts = accountRepository.count();
//        System.out.println(counts);

        //  通过 id 查询 Account 的 username
        String name = accountRepository.findNameById(3);
        System.out.println(name);
        //  关闭session，避免资源浪费
        session.close();
    }
}
