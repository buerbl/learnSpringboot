package com.example.validation.controller;

import com.example.validation.dto.Dto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author 布尔bl
 * @create 2020/3/31 11:07
 */
@RestController
public class ValidationController {
    @RequestMapping("/test")
    public String test(@RequestBody @Validated Dto dto){
        System.out.println("进检验..");
        return "test";
    }
}
