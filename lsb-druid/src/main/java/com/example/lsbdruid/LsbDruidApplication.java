package com.example.lsbdruid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.lsbdruid.mapper")
public class LsbDruidApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsbDruidApplication.class, args);
    }

}
