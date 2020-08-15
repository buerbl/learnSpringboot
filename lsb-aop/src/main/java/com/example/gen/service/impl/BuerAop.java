package com.example.gen.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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
    @Pointcut("@annotation(com.example.gen.service.Buer))")
//     2 直接扫描注解方法
//    @Pointcut("execution(* com.example.gen.service..*.*(..))")
    public void test(){

    }
//    @Before("test()")
//    public void before(){
//      log.info("我是切面");
//    }


    @Around("test()")
    public void test(ProceedingJoinPoint point){
        try {
            Object[] args = point.getArgs();  // 获取参数
            System.out.println(Arrays.toString(args));
            System.out.println("我是环绕通知前");
            point.proceed();
            System.out.println("我是环绕通止后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}



