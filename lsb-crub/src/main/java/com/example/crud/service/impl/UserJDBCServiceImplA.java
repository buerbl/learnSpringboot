package com.example.crud.service.impl;

import com.example.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserJDBCServiceImplA {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserJDBCServiceImplB userJDBCServiceImplB;

    @Transactional(rollbackFor=Exception.class)
    public int addUser() {
        User user = new User();
        user.setAddress("A");
        user.setUsername("AA");

        jdbcTemplate.update("insert into user (username,address) values (?,?);", user.getUsername(), user.getAddress());

        try{
            return userJDBCServiceImplB.addUser();
        }catch (Exception e){

        }
        return 0;
    }

    public String getUser(){
        return  jdbcTemplate.queryForObject("SELECT username FROM user WHERE id = 1", String.class);
    }
}
