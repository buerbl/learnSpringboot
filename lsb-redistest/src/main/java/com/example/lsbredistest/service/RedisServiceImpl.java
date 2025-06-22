package com.example.lsbredistest.service;

import com.example.lsbredistest.controller.entity.User;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
@Slf4j
public class RedisServiceImpl implements RedisDemoService {


    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void setValue() {


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
        stringRedisTemplate.opsForZSet().add("chen", "12", 1D);
        stringRedisTemplate.opsForZSet().add("chen", "15", 6D);

    }

    // 线程不安全
    @Override
    public void addNoSynchronized() {

        String good = stringRedisTemplate.opsForValue().get("good");
        if (good == null){
            throw new RuntimeException("没有设置商品");
        }
        Integer goodNum = Integer.parseInt(good);

        if (goodNum > 0){
            stringRedisTemplate.opsForValue().decrement("good");
        }else {
            log.info("商品已售完");
        }

    }

    @Override
    public void addSynchronized() {

        String luaScript = "local stock = redis.call('GET', 'good')\n"
                + "if stock and tonumber(stock) > 0 then\n"
                + "    return redis.call('DECR', 'good')\n"
                + "else\n"
                + "    return -1\n"
                + "end";
        org.springframework.data.redis.core.script.RedisScript<Long> script = org.springframework.data.redis.core.script.RedisScript.of(luaScript, Long.class);
        Long result = stringRedisTemplate.execute(script, Collections.singletonList("good"));
        if (result == null || result < 0) {
            log.info("商品已售完");
            throw new RuntimeException("商品已售完");
        }

    }


}
