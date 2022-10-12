package com.example.lsbcrudjpa.service.impl;


import com.example.lsbcrudjpa.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-09
 */

@Slf4j
@Service
public class UserServiceImpl  implements IUserService {


    @Override
    public Boolean saveOne() {
        return null;
    }

    @Override
    public void test1() {
        log.info("i am userServiceImpl");
    }
}
