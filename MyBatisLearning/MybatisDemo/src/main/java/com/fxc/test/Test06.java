package com.fxc.test;

import com.fxc.repository.CustomerRepository;
import com.fxc.repository.GoodsRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test06 {
    public static void main(String[] args) {
        InputStream inputStream = Test06.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession session = factory.openSession();
        //  获取代理对象
        GoodsRepository proxy = session.getMapper(GoodsRepository.class);
        System.out.println(proxy.findById(2));
        session.close();
    }
}
