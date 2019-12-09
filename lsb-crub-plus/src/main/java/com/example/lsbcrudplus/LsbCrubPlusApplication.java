package com.example.lsbcrudplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.example.lsbcrudplus.mapper")
public class LsbCrubPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsbCrubPlusApplication.class, args);
    }

    @RequestMapping
    public String hello(){

        return "LsbCrubPlus";
    }

}
