package com.example.crud.service.impl;

import com.example.crud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @Author 布尔bl
 * @create 2020/11/19 0:07
 */
//@Component
public class Compant {
    @Autowired
    private HashMap<String, IUserService> hashMap;

    public void get(){
        hashMap.forEach((k, v)-> System.out.println(k));
    }
}
