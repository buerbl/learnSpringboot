package com.example.lsbcrudplus.service.impl;

import com.example.lsbcrudplus.entity.User;
import com.example.lsbcrudplus.mapper.UserMapper;
import com.example.lsbcrudplus.service.Compent;
import com.example.lsbcrudplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lsbcrudplus.util.LsbcrudplusException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-09
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private Compent compent;

    @Override
    public Boolean saveOne() {
        User user = new User();
//        user.setAge(22);
//        user.setEmail("83@qq.com");
        user.setName("chen");
//        boolean save = super.save(user);
        Boolean save = Boolean.FALSE;
        if (save){
            return Boolean.TRUE;
        }else {
            log.info("插入失败");
            throw new LsbcrudplusException("插入失败");
        }
    }

    @Transactional
    @Override
    public void test1(User user) {
        updateById(user);
        compent.test();
    }
}
