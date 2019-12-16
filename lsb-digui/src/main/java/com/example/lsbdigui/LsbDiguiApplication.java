package com.example.lsbdigui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.lsbdigui.mapper")
public class LsbDiguiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsbDiguiApplication.class, args);
    }

}
