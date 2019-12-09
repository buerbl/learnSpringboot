package com.example.lsbcrudplus.util;

import com.example.lsbcrudplus.emum.ResultEnum;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: boolean
 * @Date: 2019/12/9 16:59
 */
@Data
public class Result {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回码状态
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object date;

    public static Result getResult(Object date){
        Result result = new Result();
//        result.setCode(200);
//        result.setMsg("正确返回");
        result.setCode(ResultEnum.RIGHT.getCode());
        result.setMsg(ResultEnum.RIGHT.getMsg());
        result.setDate(date);
        return result;
    }

    public static void main(String[] args) {
        List<String> person = new LinkedList<>();
        person.add("chen");
        person.add("wen");
        person.add("guan");
        Gson gson = new Gson();
        System.out.println(gson.toJson(getResult(person)));
    }

    @Data
    @AllArgsConstructor
    static class Person{
        private String name;
        private Integer code;
    }

}



