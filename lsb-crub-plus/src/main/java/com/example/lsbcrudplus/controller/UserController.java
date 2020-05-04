package com.example.lsbcrudplus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lsbcrudplus.entity.User;
import com.example.lsbcrudplus.service.IUserService;
import com.example.lsbcrudplus.util.Result;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 前端控制器
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
    public Result getList() {

        return Result.getResult(userService.list(new QueryWrapper<User>().select().eq("id", 1)));
//        return null;
    }

    @RequestMapping("/saveOne")
    public Result saveOne() throws Exception {
        return Result.getResult(userService.saveOne());
    }

    @GetMapping("/add")
    public synchronized Boolean add() {
        String name = "chenwe";
        List<User> list = userService.list(new QueryWrapper<User>().eq("name", name));
        if (Objects.nonNull(list) && list.size() == 0) {
            User user = new User();
            user.setName(name);
            user.setPassword("123");
            user.setAdress("中国");
            user.setStatus(0);
//            user.setAge(114);
            return userService.save(user);
        }
        return false;
    }
}

