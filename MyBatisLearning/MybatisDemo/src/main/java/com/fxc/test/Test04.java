package com.fxc.test;

import com.fxc.entity.Classes;
import com.fxc.entity.Student;
import com.fxc.repository.ClassesRepository;
import com.fxc.repository.StudentRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test04 {
    public static void main(String[] args) {
        InputStream inputStream = Test04.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession session = factory.openSession();
        //  获取代理对象
        ClassesRepository proxy = session.getMapper(ClassesRepository.class);
        System.out.println(proxy.findById(2));
        session.close();
    }
}
