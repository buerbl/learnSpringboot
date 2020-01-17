package com.example.lsbinterceptor;

import com.example.lsbinterceptor.config.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LsbInterceptorApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(LsbInterceptorApplication.class, args);
    }


    @Autowired
    private MyInterceptor myInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor);
    }
}
