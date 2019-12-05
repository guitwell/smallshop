package com.baizhi.dao;

import com.baizhi.entity.Recom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author : 张京斗
 * create_date : 2019/11/6 17:30
 * version : 1.0
 */
public interface RecomDao extends BaseDao<Recom>{
    List<Recom> findByUserId(String id);
    List<Recom> findTheFirsts(String id);
    Recom findByUserIdAndName(
            @Param("id") String id,
            @Param("name") String name);
    void addOne(@Param("id") String id,
                @Param("name") String name,
                @Param("counts") Integer counts,
                @Param("uid") String uid);
    void updateOne(@Param("id") String id,
                @Param("name") String name,
                @Param("counts") Integer counts,
                @Param("uid") String uid);
}
