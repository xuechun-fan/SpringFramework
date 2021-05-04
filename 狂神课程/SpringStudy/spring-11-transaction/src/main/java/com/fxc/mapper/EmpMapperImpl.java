package com.fxc.mapper;

import com.fxc.pojo.Emp;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class EmpMapperImpl extends SqlSessionDaoSupport implements EmpMapper {
    public List<Emp> selectEmp() {
        Emp emp = new Emp(101, "秦始皇", 66, 101, 100101);
        addEmp(emp);
        deleteEmp(5);

        return getSqlSession().getMapper(EmpMapper.class).selectEmp();
    }

    public int addEmp(Emp emp) {
        return getSqlSession().getMapper(EmpMapper.class).addEmp(emp);
    }

    public int deleteEmp(int id) {
        return getSqlSession().getMapper(EmpMapper.class).deleteEmp(id);
    }
}