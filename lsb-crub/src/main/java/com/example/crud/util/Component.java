package com.example.crud.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Component {
    RED("红色", "1"), GREEN("绿色", "2"), BLANK("白色", "3"), YELLO("黄色", "4");
    private String msg;

    private String code;



}
