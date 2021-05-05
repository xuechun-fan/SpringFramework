package com.fxc.dao;

import com.fxc.pojo.Department;
import com.fxc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//  员工Dao
@Repository
public class EmployeeDao {
    //  模拟数据库
    private static Map<Integer, Employee> employees = null;


    //  员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;
    static{
        employees = new HashMap<>();
        employees.put(1001, new Employee(1001, "小王", "aaaa@qq.com", 1, new Department(101, "研发部")));
        employees.put(1002, new Employee(1002, "小李", "bbbb@qq.com", 0, new Department(102, "研发部")));
        employees.put(1003, new Employee(1003, "小张", "cccc@qq.com", 1, new Department(103, "教学部")));
        employees.put(1004, new Employee(1004, "小范", "dddd@qq.com", 1, new Department(104, "研发部")));
        employees.put(1005, new Employee(1005, "小沈", "eeee@qq.com", 0, new Department(105, "销售部")));
    }
    //  主键自增
    private static Integer initId = 1006;

    //  增加一个员工
    public void save(Employee employee){
        if(employee.getId()==null){
//            System.out.println("[debug] ==> save");
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    //  查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //  通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //  删除员工通过id
    public void deleteById(Integer id){
        employees.remove(id);
    }

    //  修改员工信息
//    public void updateById(){}


}