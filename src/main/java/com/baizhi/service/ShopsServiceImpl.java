package com.baizhi.service;

import com.baizhi.dao.ShopsDao;
import com.baizhi.entity.Shops;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author : 张京斗
 * create_date : 2019/11/6 18:52
 * version : 1.0
 */
@Service
@Transactional
public class ShopsServiceImpl implements ShopsService {

    @Autowired
    private ShopsDao shopsDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Shops> findAll() {
        return shopsDao.findAll();
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Shops> findByName(String name) {
        return shopsDao.findByName(name);
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Shops findShopById(String id) {
        return shopsDao.findById(id);
    }

    @Override
    public void addOne(String id, String name, Integer price, Integer count, String picture, String categoryid) {
        shopsDao.addOne(id, name, price, count, picture, categoryid);
    }

    @Override
    public void updateOne(String id, String name, Integer price, Integer count, String picture, String categoryid) {
        shopsDao.updateOne(id, name, price, count, picture, categoryid);
    }
}
