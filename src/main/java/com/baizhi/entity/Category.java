package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * author : 张京斗
 * create_date : 2019/11/6 16:33
 * version : 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Component
public class Category implements Serializable {
    private String id;
    private String name;
    private String parentid;
    private Integer leval;
}
