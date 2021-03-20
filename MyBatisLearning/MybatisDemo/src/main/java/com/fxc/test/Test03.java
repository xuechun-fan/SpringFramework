package com.fxc.test;

import com.fxc.entity.Student;
import com.fxc.repository.StudentRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test03 {
    public static void main(String[] args) {
        InputStream inputStream = Test03.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession session = factory.openSession();
        //  获取代理对象
        StudentRepository proxy = session.getMapper(StudentRepository.class);
        Student student = proxy.findById(1);
        System.out.println(student);

        session.close();
    }
}
