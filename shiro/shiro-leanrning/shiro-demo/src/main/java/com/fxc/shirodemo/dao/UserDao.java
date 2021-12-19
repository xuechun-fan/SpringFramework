package com.fxc.shirodemo.dao;

import com.fxc.shirodemo.domain.UserDO;
import org.springframework.stereotype.Repository;

/**
 * @author FXC
 */
@Repository
public interface UserDao {

    /**
     * 根据ID查询用户数据
     *
     * @param id 用户ID
     * @return 返回DB中查询到的结果
     */
    UserDO selectUserById(Integer id);
}
