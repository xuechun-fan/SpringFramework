package com.fxc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot04DataApplicationTests {

    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        //  查看默认的数据源
        System.out.println(dataSource.getClass());

        //  获得数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        //  xxx Template : Springboot已经配置好模板bean，拿来即用 CRUD


        //  关闭
        connection.close();
    }

}
