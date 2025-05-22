package com.example.lsbinterceptor.service.impl;

import com.example.lsbinterceptor.config.Log;
import com.example.lsbinterceptor.service.DemoServie;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoServie {
    @Log("我是注解")
    @Override
    public void test() {
        System.out.println("执行service方法");
    }
}
