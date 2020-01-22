package com.example.lsbswagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: boolean
 * @Date: 2020/1/22 10:03
 */
@RestController
@Api(value = "用户", tags = {"用户"})
public class controller {

    @ApiOperation(value = "获取用户信息信息", notes = "根据用户的id来获取用户详细信息")
    @GetMapping("/heelo")
    public String test(){
        return "123";
    }
}



