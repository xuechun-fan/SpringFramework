package com.fxc.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

/**
 * Description：
 */
public class MyBatisTestor {
    @Test
    public void testSqlSessionFactory(){
        try {
            //  利用Reader加载classpath下的mybatis-config.xml核心配置文件
            Reader reader = Resources.getResourceAsReader("mybatisConfig.xml");
            //  初始化SqlSessionFactory对象，同时解析mybatis-config.xml文件
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            System.out.println("sqlSessionFactory加载成功");
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Connection connection = sqlSession.getConnection();
            System.out.println(connection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
