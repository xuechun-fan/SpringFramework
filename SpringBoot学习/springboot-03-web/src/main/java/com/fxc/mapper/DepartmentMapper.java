package com.fxc.mapper;

import com.fxc.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

    List<Department> queryDeptList();

    Department queryDeptById(Integer id);

    int addDept(Department department);

    int updateDept(Department department);

    int deleteDept(Integer id);
}
