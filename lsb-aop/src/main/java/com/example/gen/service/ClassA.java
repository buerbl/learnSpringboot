package com.example.gen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassA {

    private final ClassB classB;

    public ClassA(ClassB classB) {
        this.classB = classB;
    }
}
