package com.example.crud.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.crud.entity.User;
import com.example.crud.service.IUserService;
import com.example.crud.service.impl.UserJDBCServiceImpl;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

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

    @RequestMapping("/update")
    public String update(User user){
        userService.updateById(user);
        return "redirect:list";
    }

    @RequestMapping("/edit")
    public String edit(Model model, Integer id){
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @RequestMapping("/delect")
    public String delect(Integer id){
        userService.removeById(id);
        return "redirect:list";
    }

    @RequestMapping("/add")
    public String add(@ModelAttribute User user){
        userService.save(user);
        return "redirect:list";
    }

    @RequestMapping("/list")
    public String hello(Model model, @RequestParam(value = "current", required = false, defaultValue = "1") long current) {
        Page<User> curPage = new Page<>();
        curPage.setCurrent(current); // 当前页
        Page<User> page = userService.page(curPage);
        model.addAttribute("page", page);
        return "list";
    }

    @Autowired
    private UserJDBCServiceImpl userJDBCService;



    public static void main(String[] args) {
//        A a = new A("ss","sss",1);
////        B b = new B();
////        BeanUtils.copyProperties(a, b);
////        System.out.println(b.toString());
//        A a1 = new A("ss", "sss", 3);
//        A a2 = new A("ss2", "sss", 3);
//        A a3 = new A("ss3", "sss", 4);
//
//        List<A> list = new LinkedList();
//        list.add(a);
//        list.add(a1);
//        list.add(a2);
//        list.add(a3);
////        list.stream().forEach(System.out::println);
////        System.out.println(new Gs);
//        Map<String, List<A>> collect = list.stream().collect(Collectors.groupingBy(A::getName));
//
//        System.out.println(new Gson().toJson(collect));


        System.out.println(Long.parseLong("171923215912421190"));System.out.println(Long.parseLong("171923215912421190"));
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static  class A{
        private String name;
        private String adress;
        private Integer code;
    }
    @Data
    static class B{
        private String name2;
        private String adress2;
        private Integer code2;
        private String name1;
        private String adress1;
        private Integer code1;
    }

}

