package com.example.crud.service.impl;

import com.example.crud.service.CompentService;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CompentServiceImplTotal {
    private final  Map<String, CompentService> map = new ConcurrentHashMap<>();

    @Autowired
    public CompentServiceImplTotal(Map<String, CompentService> compentServiceMap) {
        this.map.clear();
        compentServiceMap.forEach(this.map::put);
        System.out.println(this.map);
    }

    public CompentService strategySelect(String mode) {
        Preconditions.checkArgument(!StringUtils.isEmpty(mode), "不允许输入空字符串");
        return this.map.get(mode);
    }

    public static void main(String[] args) {

    }
}
