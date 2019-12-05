package com.baizhi.service;

import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author : 张京斗
 * create_date : 2019/11/6 19:33
 * version : 1.0
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Category> findAllCategory() {
        return categoryDao.findAll();
    }

    @Override
    public List<Category> findAllParent() {
        return categoryDao.findAllParent();
    }

    @Override
    public List<Category> findSonCategory(String parentid) {
        return categoryDao.findSonCategory(parentid);
    }

    @Override
    public void addOneCategory(Category category) {
        categoryDao.save(category);
    }
}
