package com.baizhi.service;

import com.baizhi.entity.Shops;

import java.util.List;

/**
 * author : 张京斗
 * create_date : 2019/11/6 18:43
 * version : 1.0
 */
public interface ShopsService {
    List<Shops> findAll();
    List<Shops> findByName(String name);
    Shops findShopById(String id);
    void addOne(String id,String name, Integer price, Integer count, String picture,String categoryid);
    void updateOne(String id, String name, Integer price, Integer count, String picture,String categoryid);
}
