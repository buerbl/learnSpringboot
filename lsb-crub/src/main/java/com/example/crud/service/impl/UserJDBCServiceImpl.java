package com.example.crud.service.impl;

import com.example.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserJDBCServiceImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserJDBCServiceImplA userJDBCServiceImplA;

    @Autowired
    private UserJDBCServiceImplB userJDBCServiceImplB;

    @Transactional(rollbackFor=Exception.class)
    public int addUser() {
        User user = new User();
        user.setAddress("chen");
        user.setUsername("chen");
        jdbcTemplate.update("insert into user (username,address) values (?,?);", user.getUsername(), user.getAddress());
        return userJDBCServiceImplA.addUser();
    }

    public String getUser(){
        return  jdbcTemplate.queryForObject("SELECT username FROM user WHERE id = 1", String.class);
    }


}
