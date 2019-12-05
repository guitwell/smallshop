package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

/**
 * author : 张京斗
 * create_date : 2019/11/6 20:19
 * version : 1.0
 */
public interface UserService {
    User findByUsername(String username);
    List<User> findOneById(String id);
}
