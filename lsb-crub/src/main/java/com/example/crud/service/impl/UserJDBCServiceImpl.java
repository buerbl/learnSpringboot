package com.example.crud.service.impl;

import com.example.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserJDBCServiceImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addUser(User user) {
        return jdbcTemplate.update("insert into user (username,address) values (?,?);", user.getUsername(), user.getAddress());
    }

    public String getUser(){
        return  jdbcTemplate.queryForObject("SELECT username FROM user WHERE id = 1", String.class);
    }


}
