package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@SpringBootApplication
@RestController
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/login")
    public String login(HttpSession session){
//        session.setAttribute("USER", "1234");
        return "sss";
    }

    @GetMapping("/hello")
    public String hello(HttpSession session){
        Object user = session.getAttribute("USER");
        if (user != null){
            log.info("session为：{}", user);
        }
        return "hello";
    }
}
