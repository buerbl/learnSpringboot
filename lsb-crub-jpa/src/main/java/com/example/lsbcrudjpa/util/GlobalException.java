package com.example.lsbcrudjpa.util;

import com.example.lsbcrudjpa.enums.ResultEnum;
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
        result.setCode(ResultEnum.ERROR.getCode());
        result.setMsg(ResultEnum.ERROR.getMsg());
        result.setDate(e.getMessage());
        log.error("报错了",e);
        return result;
    }


}



