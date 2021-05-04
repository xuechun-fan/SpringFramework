package com.fxc.mapper;

import com.fxc.pojo.Emp;

import java.util.List;

public interface EmpMapper {
    public List<Emp> selectEmp();

    //添加一个用户
    public int addEmp(Emp emp);

    //删除一个用户
    public int deleteEmp(int id);
}
