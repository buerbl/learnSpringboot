package com.example.gen.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author 布尔bl
 * @create 2020/3/31 15:21
 */
@Data
public class NotNullDto {
    @NotNull(message ="字段不能为null") // 使用所有类型
    private Integer name;
}
