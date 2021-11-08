package com.example.lsbcrudplus;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.lsbcrudplus.entity.User;
import com.example.lsbcrudplus.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
@MapperScan("com.example.lsbcrudplus.mapper")
@Slf4j
public class LsbCrubPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsbCrubPlusApplication.class, args);

    }

    @Autowired
    private IUserService userService;

    @RequestMapping
    public String hello() {

        return "LsbCrubPlus";
    }

    @GetMapping("/list")
    public User list() {
        log.info("开始查询");
        List<User> userList = userService.list();
        userList.forEach(System.out::println);
        System.out.println("============================");
        userList.forEach(System.out::println);
        System.out.println("==============================");
        userList.stream().filter(u -> u.getId() == 1).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("===============================");
        userList.stream().map(User::getId).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("=====================1");
        Map<Long, String> longStringMap = userList.stream().collect(Collectors.toMap(User::getId, User::getName));

        longStringMap.forEach((k, v) -> System.out.println(k + "--" + v));
        return null;
    }


}
