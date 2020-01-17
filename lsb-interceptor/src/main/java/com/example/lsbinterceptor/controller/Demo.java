package com.example.lsbinterceptor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: boolean
 * @Date: 2020/1/17 16:50
 */
@Slf4j
@RestController
public class Demo {
    @RequestMapping("/test")
    public String test(){
        log.info("我是控制层");
        return "well";
    }
}



