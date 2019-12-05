package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * author : 张京斗
 * create_date : 2019/10/30 18:42
 * version : 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Manager implements Serializable {
    private String id;
    private String name;
    private String realname;
    private String password;
    private String sex;
}
