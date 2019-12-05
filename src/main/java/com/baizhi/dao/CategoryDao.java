package com.baizhi.dao;

import com.baizhi.entity.Category;

import java.util.List;

/**
 * author : 张京斗
 * create_date : 2019/11/6 16:48
 * version : 1.0
 */
public interface CategoryDao extends BaseDao<Category> {
    List<Category> findAllParent();
    List<Category> findSonCategory(String parentid);
}
