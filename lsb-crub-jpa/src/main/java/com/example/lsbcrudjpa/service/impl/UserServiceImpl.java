package com.example.lsbcrudjpa.service.impl;


import com.example.lsbcrudjpa.dao.UserRepository;
import com.example.lsbcrudjpa.entity.User;
import com.example.lsbcrudjpa.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-09
 */

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean saveOne() {
        return null;
    }

    @Override
    public void test1() {
        log.info("i am userServiceImpl");
    }

    @Override
    public Long countByName(String name) {
        return userRepository.countByName(name);
    }

    @Override
    public List<User> findByAdressOrderByName(String adress) {
        return userRepository.findByAdressOrderByName(adress);
    }

    @Override
    public Page<User> queryFirst10ByAdress(String adress, Pageable pageable) {
        return userRepository.queryFirst10ByAdress(adress, pageable);
    }

}
