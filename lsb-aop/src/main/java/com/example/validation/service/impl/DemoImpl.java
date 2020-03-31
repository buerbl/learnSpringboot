package com.example.validation.service.impl;

import com.example.validation.service.Buer;
import com.example.validation.service.Idemo;
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
    public void demo() {
      log.info("我是Service");
    }
}



