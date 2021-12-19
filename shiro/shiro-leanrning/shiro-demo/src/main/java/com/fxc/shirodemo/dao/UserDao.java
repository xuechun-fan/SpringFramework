package com.fxc.shirodemo.dao;

import com.fxc.shirodemo.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author FXC
 */
@Mapper
@Repository
public interface UserDao {

    /**
     * 根据用户名查询用户数据
     *
     * @param username 用户名
     * @return 返回DB中查询到的结果
     */
    UserDO selectUserByName(String username);
}
