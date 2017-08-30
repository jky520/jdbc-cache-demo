package com.jky.springboot.jdbcche.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体
 * Created by DT人 on 2017/8/30 11:10.
 */
@Data // 自动生成getter和setter方法
@Builder // 会自定构建建造模式
@NoArgsConstructor // 自动创建无惨构造函数
@AllArgsConstructor // 自动创建全参数的构造函数
public class User {
    private Integer id;
    private String username;
    private String password;
}
