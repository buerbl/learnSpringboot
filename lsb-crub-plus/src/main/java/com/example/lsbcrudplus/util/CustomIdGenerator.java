package com.example.lsbcrudplus.util;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * ，mybatis自定义id生成器
 */
@Slf4j
@Component
public class CustomIdGenerator implements IdentifierGenerator {
    private final AtomicLong al = new AtomicLong(1);


    @Override
    public Number nextId(Object entity) {
        // 填充自己的Id生成器，
        return IdGenerator.generateId();
    }
}
