package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author : 张京斗
 * create_date : 2019/11/6 17:31
 * version : 1.0
 */
public interface UserDao extends BaseDao<User> {
    User findOneByUsername(@Param("username") String username);
    List<User> findOneById(@Param("userid") String id);
}
