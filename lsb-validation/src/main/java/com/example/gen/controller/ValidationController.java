package com.example.gen.controller;

import com.example.gen.dto.NotBlankDto;
import com.example.gen.dto.NotEmptyDto;
import com.example.gen.dto.NotNullDto;
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

    @RequestMapping("/NotBlankDto")
    public String test(@RequestBody @Validated NotBlankDto dto){
        System.out.println("进检验..");
        return "NotBlankDto";
    }

    @RequestMapping("/NotNullDto")
    public String test(@RequestBody @Validated NotNullDto dto){
        System.out.println("进检验..");
        return "NotNullDto";
    }

    @RequestMapping("/NotEmptyDto")
    public String test(@RequestBody @Validated NotEmptyDto dto){
        System.out.println("进检验..");
        return "NotEmptyDto";
    }
}
