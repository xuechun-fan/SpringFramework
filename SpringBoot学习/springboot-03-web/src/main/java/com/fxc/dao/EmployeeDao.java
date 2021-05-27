package com.fxc.dao;

import com.fxc.mapper.EmployeeMapper;
import com.fxc.pojo.Department;
import com.fxc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


//  员工Dao
@Repository
public class EmployeeDao {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> queryEmpList() {
        return employeeMapper.queryEmpList();
    }

    //  根据id查询
    public Employee queryEmpById(Integer id) {
        return employeeMapper.queryEmpById(id);
    }

    //  增
    public int addEmp(Employee employee) {
        return employeeMapper.addEmp(employee);
    }

    //  改
    public int updateEmp(Employee employee) {
        return employeeMapper.updateEmp(employee);
    }

    //  删
    public int deleteEmpById(Integer id) {
        return employeeMapper.deleteEmpById(id);
    }

}