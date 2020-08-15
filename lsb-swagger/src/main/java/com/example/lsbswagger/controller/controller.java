package com.example.lsbswagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
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
    public U test(){
        return new U();
    }
    @ApiOperation(value = "获取用户信息信息1", notes = "根据用户的id来获取用户详细信息")
    @GetMapping("/heelo1")
    public U1 test1(){
        return new U1();
    }
    @ApiOperation(value = "获取用户信息信息2", notes = "根据用户的id来获取用户详细信息")
    @GetMapping("/heelo2")
    public U test2(){
        return new U();
    }
    @ApiOperation(value = "获取用户信息信息3", notes = "根据用户的id来获取用户详细信息")
    @GetMapping("/heelo3")
    public U test3(){
        return new U();
    }

    @Data
    @ApiModel("用户实体")
    private class U {
        @ApiModelProperty("用户 id")
        private int id;
        @ApiModelProperty("用户 name")
        private String name;

    }

    @Data
    @ApiModel("用户实体2")
    private class U1 {
        @ApiModelProperty("用户 id")
        private int id;
        @ApiModelProperty("用户 name")
        private String name;

    }
}



