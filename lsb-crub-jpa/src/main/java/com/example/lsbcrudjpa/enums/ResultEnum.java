package com.example.lsbcrudjpa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description:
 * @Author: boolean
 * @Date: 2019/12/9 23:37
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {
    RIGHT(200, "正确返回"),
    ERROR(404,"错误返回");

    private Integer code;

    private String msg;
}



