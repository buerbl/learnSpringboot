package com.example.lsbcrudplus.service;

import com.example.lsbcrudplus.entity.User;
import com.example.lsbcrudplus.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author 布尔bl
 * @create 2020/11/9 22:57
 */
@Service
public class Compent {
    @Resource
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void test(){
        User user = new User();
        user.setName("chen1");
        user.setId(1L);
        userMapper.updateById(user);
    }
}
