package com.example.lsbredistest.controller;

import com.example.lsbredistest.controller.entity.User;
import com.google.gson.Gson;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: boolean
 * @Date: 2020/1/6 15:47
 */
@RestController
@RequestMapping("/lsbredis")
public class RedisController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/test")
    public void test(){

        // key : a value: a
        // 增
        stringRedisTemplate.opsForValue().set("a","a");
        // 查
        String a = stringRedisTemplate.opsForValue().get("a");
        System.out.println("a的值:"+a);
        // 改
        stringRedisTemplate.opsForValue().set("a","b");

        // 缓存一个对象
        List<User> list = new ArrayList<>();
        list.add(new User(1l, "c1",1, "s1"));
        list.add(new User(2l, "c2",2, "s2"));
        list.add(new User(3l, "c3",3, "s3"));
        Gson gson = new Gson();
        String toJson = gson.toJson(list);
        stringRedisTemplate.opsForValue().set("user",toJson);
    }

}


