package com.example.crud.service.impl;

import com.example.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserJDBCServiceImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addUser(User user) {
        return jdbcTemplate.update("insert into user (username,address) values (?,?);", user.getUsername(), user.getAddress());
    }
}
