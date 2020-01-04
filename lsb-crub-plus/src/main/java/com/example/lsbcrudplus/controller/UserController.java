package com.example.lsbcrudplus.controller;


import com.example.lsbcrudplus.service.IUserService;
import com.example.lsbcrudplus.util.Result;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-09
 */
@Log
@RestController
@RequestMapping("/lsbcrud/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/getList")
    public Result getList(){
        int a = 1/0;

        return Result.getResult(userService.list());
    }

    @RequestMapping("/saveOne")
    public Result saveOne() throws Exception {
//        throw new Exception("RR");
        return Result.getResult(userService.saveOne());
    }
}

