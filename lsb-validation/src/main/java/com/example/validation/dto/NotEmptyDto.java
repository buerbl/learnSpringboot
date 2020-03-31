package com.example.validation.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author 布尔bl
 * @create 2020/3/31 15:26
 */
@Data
public class NotEmptyDto {
    @NotEmpty(message = "字段不能为null或者空字符")
    private String name;
}
