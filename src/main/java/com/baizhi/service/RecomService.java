package com.baizhi.service;

import com.baizhi.entity.Recom;

import java.util.List;

/**
 * author : 张京斗
 * create_date : 2019/11/6 21:21
 * version : 1.0
 */
public interface RecomService {
    List<Recom> findByUserId(String userid);
    List<Recom> findTheFirsts(String userid);
    Recom findByUserIdAndName(String userid,String name);
    void addOne(String id, String name, Integer counts, String uid);
    void updateOne(String id, String name, Integer counts, String uid);
}
