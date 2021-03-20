package com.fxc.test;

import com.fxc.entity.Customer;
import com.fxc.repository.ClassesRepository;
import com.fxc.repository.CustomerRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test05 {
    public static void main(String[] args) {
        InputStream inputStream = Test05.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession session = factory.openSession();
        //  获取代理对象
        CustomerRepository proxy = session.getMapper(CustomerRepository.class);
        System.out.println(proxy.findById(3));
        session.close();
    }
}
