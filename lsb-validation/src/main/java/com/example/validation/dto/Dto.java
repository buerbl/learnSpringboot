package com.example.validation.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @Author 布尔bl
 * @create 2020/3/31 11:09
 */
@Data
public class Dto {
    @NotBlank(message = "不能为null或者空字符") //不能为空 空字符串也不行
    private String name;


}
