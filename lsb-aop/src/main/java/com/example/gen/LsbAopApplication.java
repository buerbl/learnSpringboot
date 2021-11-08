package com.example.gen;

import com.example.gen.service.Idemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableAsync
public class LsbAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsbAopApplication.class, args);
    }
    @Autowired
    private Idemo idemoImpl;
    @RequestMapping
    public void test(){
        idemoImpl.demo(new Entity(1,"sa"));
        System.out.println("执行controller方法");
    }


}
