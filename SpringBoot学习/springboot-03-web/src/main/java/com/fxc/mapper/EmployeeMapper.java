package com.fxc.mapper;

import com.fxc.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {

    //  查
    //  查询所有员工
    List<Employee> queryEmpList();

    //  根据id查询
    Employee queryEmpById(Integer id);

    //  增
    int addEmp(Employee employee);

    //  改
    int updateEmp(Employee employee);

    //  删
    int deleteEmpById(Integer id);

}
