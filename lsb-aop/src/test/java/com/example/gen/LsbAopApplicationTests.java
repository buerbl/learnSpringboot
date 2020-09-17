package com.example.gen;

import com.example.gen.service.AsyncService;
import com.example.gen.service.Idemo;
import com.example.gen.service.impl.AsyncServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class LsbAopApplicationTests {

    @Autowired
    private Idemo idemo;
    @Test
    public void contextLoads() {
//        idemo.demo("ss");
    }

    @Autowired
    private AsyncServiceImpl asyncService;

    @Test
    public void  test(){
        asyncService.testAsync("chen");
        log.info("Test");
    }
}
