package com.example.lsbaop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: boolean
 * @Date: 2020/1/17 14:27
 */
@Component
@Aspect
@Slf4j
public class BuerAop {
    // 1 直接扫描注解
    //@Pointcut("@annotation(com.example.springbootaop.service.Buer))")
    // 2 直接扫描注解方法
    @Pointcut("execution(* com.example.lsbaop.service..*.*(..))")
    public void test(){

    }
    @Before("test()")
    public void before(){
      log.info("我是切面");
    }
}



