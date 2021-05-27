package com.fxc.dao;

import com.fxc.mapper.DepartmentMapper;
import com.fxc.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  部门Dao
@Repository
public class DepartmentDao {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> queryDeptList() {
        return departmentMapper.queryDeptList();
    }

    public Department queryDeptById(Integer id) {
        return departmentMapper.queryDeptById(id);
    }

    public int addDept(Department department) {
        return departmentMapper.addDept(department);
    }

    public int updateDept(Department department) {
        return departmentMapper.updateDept(department);
    }

    int deleteDept(Integer id) {
        return departmentMapper.deleteDept(id);
    }
}