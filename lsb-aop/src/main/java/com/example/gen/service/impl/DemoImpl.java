package com.example.gen.service.impl;

import com.example.gen.Entity;
import com.example.gen.service.Buer;
import com.example.gen.service.Idemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: boolean
 * @Date: 2020/1/17 14:25
 */
@Slf4j
@Service
public class DemoImpl implements Idemo {
    @Override
    @Buer
    public void demo(Entity entity) {
      log.info("我是Service");
    }
}



