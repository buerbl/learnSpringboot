package com.example.gen.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author 布尔bl
 * @create 2020/3/31 11:09
 */
@Data
public class NotBlankDto {
    @NotBlank(message = "字段不能为null或者空字符") // 需要是字符
    private String name;
}
