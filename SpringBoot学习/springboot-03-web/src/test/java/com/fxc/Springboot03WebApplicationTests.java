package com.fxc;

import com.fxc.dao.DepartmentDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.zip.DataFormatException;

@SpringBootTest
class Springboot03WebApplicationTests {

    @Test
    void contextLoads() {
        DepartmentDao departmentDao = new DepartmentDao();
        System.out.println(departmentDao.getDepartmentById(105));

    }

}
