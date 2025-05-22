package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class Application {


    @Autowired
    private static ComponentTwo componentTwo;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        log.info("启动成功！");
        // 从 Spring 容器中获取 comOne 实例
        ComOne comOne = context.getBean(ComOne.class);
        comOne.test();

        ComponentTwo componentTwo = context.getBean(ComponentTwo.class);
        componentTwo.test();
//        componentTwo.test();

    }

}

