package com.fxc.mapper;

import com.fxc.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
//    public User queryUserById(Integer id);

    public User queryUserByUsername(String username);
}
