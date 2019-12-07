package com.example.crud.controller;


import com.example.crud.entity.User;
import com.example.crud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-06
 */
@RestController
@RequestMapping("/crud/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/getAll")
    public List<User> getAll(){
        return userService.list();
    }
}

