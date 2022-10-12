package com.example.lsbcrudjpa;

import com.example.lsbcrudjpa.service.IUserService;
import com.example.lsbcrudjpa.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class LsbCrubJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsbCrubJpaApplication.class, args);
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(UserServiceImpl.class);
//        //打印所有在容器中的实例（Bean）
//        String[] beanNames = applicationContext.getBeanDefinitionNames();
//        for (String beanName : beanNames) {
//            System.out.println("sss：“" + beanName);
//
//        }
    }

    @Autowired
    private IUserService userService;

    @GetMapping("/demo")
    public String hello() {
        return "LsbCrubJpa";
    }

    @GetMapping("/user")
    public void user() {
        userService.test1();
    }


}
