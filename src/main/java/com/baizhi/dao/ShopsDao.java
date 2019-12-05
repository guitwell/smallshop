package com.baizhi.dao;

import com.baizhi.entity.Shops;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author : 张京斗
 * create_date : 2019/11/6 16:50
 * version : 1.0
 */
public interface ShopsDao extends BaseDao<Shops> {
    List<Shops> findByName(@Param("name") String name);
    void addOne(@Param("id") String id,
                @Param("name") String name,
                @Param("price") Integer price,
                @Param("count") Integer count,
                @Param("picture") String picture,
                @Param("categoryid") String categoryid);
    void updateOne(@Param("id") String id,
                   @Param("name") String name,
                   @Param("price") Integer price,
                   @Param("count") Integer count,
                   @Param("picture") String picture,
                   @Param("categoryid") String categoryid);
}
