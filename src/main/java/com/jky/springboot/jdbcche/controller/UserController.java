package com.jky.springboot.jdbcche.controller;

import com.jky.springboot.jdbcche.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 * Created by DT人 on 2017/8/30 11:21.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/index")
    public String index() {
        return null;
    }
}
