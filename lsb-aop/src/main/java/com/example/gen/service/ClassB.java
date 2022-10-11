package com.example.gen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassB {

    private final ClassA classA;

    public ClassB(ClassA classA) {
        this.classA = classA;
    }
}
