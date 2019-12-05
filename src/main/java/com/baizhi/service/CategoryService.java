package com.baizhi.service;

import com.baizhi.entity.Category;

import java.util.List;

/**
 * author : 张京斗
 * create_date : 2019/11/6 19:32
 * version : 1.0
 */
public interface CategoryService {
    List<Category> findAllCategory();
    List<Category> findAllParent();
    List<Category> findSonCategory(String parentid);
    void addOneCategory(Category category);
}
