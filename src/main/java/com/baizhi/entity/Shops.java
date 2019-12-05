package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * author : 张京斗
 * create_date : 2019/11/6 16:38
 * version : 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Shops implements Serializable {
    private String id;
    private String name;
    private Integer price;
    private Integer count;
    private String picture;
    private Category category;
}
