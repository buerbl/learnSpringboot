package com.example.lsbinterceptor.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component// 声明这是一个切面类
public class LogAspect {

    @Around("@annotation(log)")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint, Log log) throws Throwable {

        String methodName = joinPoint.getSignature().getName();
        String logMessage = log.value().isEmpty() ?
                "Executing method: " + methodName : log.value();

        // 打印日志（前置通知）
        System.out.println("[LOG] START: " + logMessage);

        try {
            Object result = joinPoint.proceed();  // 执行目标方法
            // 打印日志（返回通知）
            System.out.println("[LOG] SUCCESS: " + methodName);
            return result;
        } catch (Exception e) {
            // 打印日志（异常通知）
            System.out.println("[LOG] ERROR: " + methodName + " - " + e.getMessage());
            throw e;
        }
    }
}
