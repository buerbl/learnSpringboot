package com.example.gen.service.impl;

import com.example.gen.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author 布尔bl
 * @create 2020/8/31 23:52
 */
@Slf4j
@Component
public class AsyncServiceImpl {

    @Async
    public void testAsync(String name) {
        log.info("异步开始");
        System.out.println(11);
        try {
            Thread.sleep(1000);
            System.out.println(name);
            log.info(name);
            int i = 1 / 0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("结束");
    }
}

