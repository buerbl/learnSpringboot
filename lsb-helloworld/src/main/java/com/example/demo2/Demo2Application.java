package com.example.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class Demo2Application {

    public static void main(String[] args) {
        E e = (E) SpringApplication.run(Demo2Application.class, args).getBean("ss");
        e.test();
    }



    @Service(value = "ss")
    class E {
        public void test() {
            System.out.println("service1111111");
        }
    }
}
