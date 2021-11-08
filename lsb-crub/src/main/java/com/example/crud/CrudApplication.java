package com.example.crud;

import com.example.crud.service.AsyncService;
import com.example.crud.service.impl.TestService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.example.crud.mapper")
@EnableAsync
@EnableTransactionManagement

public class CrudApplication  {
    @Autowired
    private AsyncService asyncService;

    @Autowired
    private TestService testService;

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

    @RequestMapping("/lsb_crub")
    public String test(){
        return "hello,crud";
    }

    @RequestMapping("/aad")
    public String test1(){
        try {
            testService.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }



}
