package com.example.lsbdruid.controller;


import com.example.lsbdruid.entity.MyUser;
import com.example.lsbdruid.service.IMyUserService;
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
 * @since 2020-01-15
 */
@RestController
@RequestMapping("/my-user")
public class MyUserController {
    @Autowired
    private IMyUserService myUserService;
    @RequestMapping("/add")
    public String add(){
        MyUser myUser = new MyUser();
        myUser.setAge(18);
        myUser.setEmail("83");
        myUser.setName("布尔bl");
        return myUserService.save(myUser) ? "1": "0";
    }

    @RequestMapping("/get")
    public List<MyUser> get(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myUserService.list();
    }

}

