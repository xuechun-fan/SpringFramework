package com.fxc.controller;

import com.fxc.mapper.EmployeeMapper;
import com.fxc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeMapper employeeMapper;

    @ResponseBody
    @GetMapping("/queryEmpList")
    public List<Employee> queryEmpList(){
        List<Employee> employees = employeeMapper.queryEmpList();
        for(Employee employee:employees){
            System.out.println(employee);
        }
        return employees;
    }

    @GetMapping("/findById/{id}")
    @ResponseBody
    public Employee findById(@PathVariable("id")Integer id){
        return employeeMapper.findById(id);
    }

    @GetMapping("/addEmp")
    public String addEmp(){
        Employee employee = new Employee(32, "张小花", 66, 3, 100099);
        employeeMapper.addEmp(employee);
        return "redirect:/queryEmpList";
    }

    @GetMapping("/updateEmp")
    public String updateEmp(){
        Employee employee = new Employee(32, "李晓明", 26, 3, 100032);
        employeeMapper.updateEmp(employee);
        return "redirect:/queryEmpList";
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeMapper.deleteEmp(id);
        return "redirect:/queryEmpList";
    }
}