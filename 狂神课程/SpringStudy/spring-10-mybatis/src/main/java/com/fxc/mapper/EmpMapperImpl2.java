package com.fxc.mapper;

import com.fxc.pojo.Emp;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class EmpMapperImpl2 extends SqlSessionDaoSupport implements EmpMapper {
    public List<Emp> selectEmp() {
        return getSqlSession().getMapper(EmpMapper.class).selectEmp();
    }
}