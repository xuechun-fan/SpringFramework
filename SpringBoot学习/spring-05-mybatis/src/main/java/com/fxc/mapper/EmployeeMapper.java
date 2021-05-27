package com.fxc.mapper;

import com.fxc.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//  注解表示这是一个Mybatis的类 Dao
@Mapper
@Repository
public interface EmployeeMapper {
    //  采用注解的方式进行查询
    @Select("SELECT * FROM mydb.t_emp WHERE id=#{id}")
    Employee findById(@Param("id") Integer id);

    //  剩下四种使用传统的Mybatis配置文件方式，这种方式需要创建与该mapper对应的xml配置文件
    //  并在application配置文件中配置mybatis整合
    List<Employee> queryEmpList();

    int addEmp(Employee employee);

    int updateEmp(Employee employee);

    int deleteEmp(Integer id);
}