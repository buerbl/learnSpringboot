package com.example.lsbredistest.controller;

import com.example.lsbredistest.service.RedisDemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: boolean
 * @Date: 2020/1/6 15:47
 */
@RestController
@RequestMapping("/lsbredis")
public class RedisController {

    @Resource
    private RedisDemoService redisService;

    @RequestMapping("/test")
    public void test(){
        redisService.setValue();
    }

}


