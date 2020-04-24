package com.example.validation;

import com.example.validation.service.Idemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LsbAopApplicationTests {

    @Autowired
    private Idemo idemo;
    @Test
    public void contextLoads() {
//        idemo.demo("ss");
    }
}
