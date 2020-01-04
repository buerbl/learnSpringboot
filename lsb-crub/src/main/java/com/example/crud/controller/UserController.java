package com.example.crud.controller;


import com.example.crud.entity.User;
import com.example.crud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-06
 */
@Controller
@RequestMapping("/crud/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @ResponseBody
    @RequestMapping("/getAll")
    public List<User> getAll(){
        return userService.list();
    }

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, @RequestParam(value = "name", required = false, defaultValue = "springboot-thymeleaf") String name) {
        List<User> empList = new ArrayList<>();
        empList.add(new User(1, "校长", 24));
        empList.add(new User(2, "书记", 28));
        empList.add(new User(3, "小海", 25));
        request.setAttribute("userList", empList);
        request.setAttribute("name", name);
        return "hello";
    }
}

