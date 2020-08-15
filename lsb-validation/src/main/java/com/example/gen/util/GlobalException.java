package com.example.gen.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @Description: 全局的异常返回
 * @Author: boolean
 * @Date: 2019/12/10 0:14
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {

    // 拦截器
    @ExceptionHandler({Exception.class})
    public Result exception(Exception e){
        Result result = new Result();
        result.setCode(500);
        result.setMsg(e.getMessage());
        log.error("报错了",e);
        return result;
    }


}



