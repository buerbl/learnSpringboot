package com.example.demo.controller;

import com.example.demo.Dto.Dto;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.function.DoubleToIntFunction;


/**
 * @Description:
 * @Author: boolean
 * @Date: 2020/1/31 21:48
 */
@Controller
@Slf4j
public class TestController {
    @GetMapping("/test")
    public String test(Model model){
        log.info("测试thymeleaf");
        // 那数据放进 model
        model.addAttribute("name", "布尔bl");
        return "hello";
    }

    @GetMapping("/add")
    public String add(){
        log.info("测试增加用户");
        return "/user/add";
    }

    @GetMapping("/update")
    public String update(){
        log.info("测试更新用户");
        return "/user/update";
    }

    @GetMapping("/tologin")
    public String tologin(){
        log.info("测试拦截");
        return "login";
    }

    @GetMapping("/noauto")
    public String noauto(){
        log.info("测试授权拦截");
        return "noauto";
    }

    @GetMapping("/logout")
    public String logout(){
        log.info("测试退出");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        if (subject.getSession() == null) {
            log.info("sesion没有了");
        }
        return "logout";
    }

    @PostMapping("/login")
    public String login( Dto dto, HttpSession session){
        log.info("登录");
        log.info(dto.getName()+"+"+dto.getPassword());
        // 1. 获取 Subject
        Subject subject  = SecurityUtils.getSubject();

        Serializable id = subject.getSession().getId();
        session.setAttribute("cookie", id);

        log.info("sessionid为:{}", id);

        // 2. 封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(dto.getName(), dto.getPassword());
        log.info("token:{}", token);
        try {
            subject.login(token);


        } catch (UnknownAccountException e){
//            model.addAttribute("msg", "用户名不存在");
            log.info("用户名不存在");
            return "hello";
        }catch (IncorrectCredentialsException e){
//            model.addAttribute("msg", "密码错误");
            log.info("密码错误");
            return "hello";
        }
        return "hello";
    }

    @PostMapping("/app")
    public String app(HttpServletRequest request){
        HttpSession session = request.getSession();
        log.info("session为:{}", session.getId());
        return "app";
    }
}



