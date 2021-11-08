package com.example.crud.service.impl;

import com.example.crud.service.CompentService;
import org.springframework.stereotype.Component;

@Component("CompentServiceImplOne")
public class CompentServiceImplOne implements CompentService {
    @Override
    public void test(String name) {
        System.out.println("CompentServiceImplOne"+name);
    }
}
