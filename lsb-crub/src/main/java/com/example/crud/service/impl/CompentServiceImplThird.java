package com.example.crud.service.impl;

import com.example.crud.service.CompentService;
import org.springframework.stereotype.Component;

@Component
public class CompentServiceImplThird implements CompentService {
    @Override
    public void test(String name) {
        System.out.println("CompentServiceImplThird"+name);
    }
}
