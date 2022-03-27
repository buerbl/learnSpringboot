package com.example.crud.service.impl;

import com.example.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserJDBCServiceImplB {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor=Exception.class,propagation = Propagation.REQUIRES_NEW)
    public int addUser() {
        User user = new User();
        user.setUsername("BB");
        user.setAddress("B");
        int a= 0;
        System.out.println(2 / a);
        return jdbcTemplate.update("insert into user (username,address) values (?,?);", user.getUsername(), user.getAddress());
    }

    public String getUser(){
        return  jdbcTemplate.queryForObject("SELECT username FROM user WHERE id = 1", String.class);
    }
}
