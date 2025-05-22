package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComponentTwo {

    @Bean
    public void test() {
        System.out.println("ComponentTwo test");
    }

}
