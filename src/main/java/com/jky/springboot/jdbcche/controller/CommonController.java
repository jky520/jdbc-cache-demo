package com.jky.springboot.jdbcche.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DT人 on 2017/8/30 11:37.
 */
@RestController
@Slf4j // 这个也是lombok的注解
public class CommonController {

    @Value("${jky.name:jky}") // 设置默认值为jky
    private String commonStr;

    public String valueCommon() {
        // log.info("common str is {}", commonStr); // {}是字符串占位符，自动把后面的字符串变量替换掉{}
        return "";
    }
}
