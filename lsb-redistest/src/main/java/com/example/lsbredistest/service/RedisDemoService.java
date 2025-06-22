package com.example.lsbredistest.service;

import org.springframework.stereotype.Service;


public interface RedisDemoService {
    void setValue();

    void addNoSynchronized();

    void addSynchronized();


}
