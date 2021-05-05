package com.fxc.dao;

import com.fxc.pojo.Department;
import com.fxc.pojo.Employee;
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
    private DepartmentDao departmentDao;
    static{
        employees = new HashMap<>();
        employees.put(101, new Employee(1001, "A", "aaaa@qq.com", 1, new Department(101, "研发部")));
        employees.put(102, new Employee(1002, "B", "bbbb@qq.com", 0, new Department(102, "研发部")));
        employees.put(103, new Employee(1003, "C", "cccc@qq.com", 1, new Department(103, "教学部")));
        employees.put(104, new Employee(1004, "D", "dddd@qq.com", 1, new Department(104, "研发部")));
        employees.put(105, new Employee(1005, "E", "eeee@qq.com", 0, new Department(105, "销售部")));
    }
    //  主键自增
    private static Integer initId = 1006;

    //  增加一个员工
    public void save(Employee employee){
        if(employee.getId()==null){
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