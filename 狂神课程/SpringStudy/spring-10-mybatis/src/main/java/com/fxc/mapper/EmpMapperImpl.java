package com.fxc.mapper;

import com.fxc.pojo.Emp;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class EmpMapperImpl implements EmpMapper{
    //  我们的所有操作，都是sqlSession来执行，在原来，现在都是用SqlSessionTemplate;
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Emp> selectEmp() {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        return mapper.selectEmp();
    }
}