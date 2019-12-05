package com.baizhi.service;

import com.baizhi.entity.Manager;

/**
 * author : 张京斗
 * create_date : 2019/10/31 20:16
 * version : 1.0
 */
public interface ManagerService {
    Manager findOne(String name);
    void addOne(Manager manager);
}
