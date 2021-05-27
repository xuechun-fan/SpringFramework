package com.fxc.controller;

import com.fxc.dao.DepartmentDao;
import com.fxc.dao.EmployeeDao;
import com.fxc.pojo.Department;
import com.fxc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/index")
    public String index() {
        return "/index";
    }

    @RequestMapping("/emps")
    public String list(Model model) {
        //  查询所有员工信息
        Collection<Employee> employees = employeeDao.queryEmpList();
        model.addAttribute("emps", employees);
        //  部门位置通过id对应，找出相应的文字显示
        Collection<Department> departments = departmentDao.queryDeptList();
        Map<Integer, String> depts = new HashMap<>();
        for (Department department :
                departments) {
            depts.put(department.getId(), department.getDeptName());
        }
        model.addAttribute("depts", depts);
        return "emp/list";
    }

    @GetMapping("/toAddPage")
    public String toAddPage(Model model) {
        //  查询所有部门信息，并添加到 model 中
        Collection<Department> departments = departmentDao.queryDeptList();
        model.addAttribute("departments", departments);
        return "emp/addPage";
    }

    @PostMapping("/addEmp")
    public String addEmp(Employee employee) {
        //  添加员工业务。
        employeeDao.addEmp(employee); //  调用底层业务方法，保存员工信息
        System.out.println("[debug] save ===> " + employee);
        return "redirect:/emps";
    }

    //  去员工的修改页面
    @GetMapping("/toUpdatePage/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
        //  查询所有部门信息，并添加到 model 中
        Collection<Department> departments = departmentDao.queryDeptList();
        model.addAttribute("departments", departments);
        //  传递员工id参数
        Employee employee = employeeDao.queryEmpById(id);
        model.addAttribute("emp", employee);
//        System.out.println("[debug] updateEmp ==>  id : " + id);
        return "emp/updatePage";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        //  更新员工信息业务
        employeeDao.updateEmp(employee);
        return "redirect:/emps";
    }


    //  删除员工
    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        //  删除员工信息业务
        employeeDao.deleteEmpById(id);
        return "redirect:/emps";
    }

}