package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * author : 张京斗
 * create_date : 2019/11/6 16:27
 * version : 1.0
 */
@SpringBootApplication
@MapperScan("com.baizhi.dao")
public class SmallShopApplication {
    public static void main(String[] args){
        SpringApplication.run(SmallShopApplication.class, args);
    }
}
