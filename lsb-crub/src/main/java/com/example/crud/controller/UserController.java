package com.example.crud.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.crud.entity.User;
import com.example.crud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
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
}

