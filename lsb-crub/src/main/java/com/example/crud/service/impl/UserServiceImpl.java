package com.example.crud.service.impl;

import com.example.crud.entity.User;
import com.example.crud.mapper.UserMapper;
import com.example.crud.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-06
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Override
	public void test() {
		log.info("我是[{}]", this.getClass().getName());
	}
}
