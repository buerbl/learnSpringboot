package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class LsbSchduledTaskApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(LsbSchduledTaskApplication.class, args);
        Test bean = (Test) run.getBean("scheduled");
        bean.test();
    }

    @Service(value = "scheduled")
    class Test {
        public void test() {
            System.out.println("scheduled");
        }
    }
}
