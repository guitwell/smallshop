package com.baizhi.dao;


import com.baizhi.entity.Manager;
import org.apache.ibatis.annotations.Param;

/**
 * author : 张京斗
 * create_date : 2019/10/30 18:57
 * version : 1.0
 */
public interface ManagerDao extends BaseDao<Manager>{
    Manager findOne(@Param("name") String name);
}
