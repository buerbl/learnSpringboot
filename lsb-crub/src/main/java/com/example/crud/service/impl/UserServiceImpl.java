package com.example.crud.service.impl;

import com.example.crud.entity.User;
import com.example.crud.mapper.UserMapper;
import com.example.crud.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

	@Resource
	private UserMapper userMapper;

	@Override
	public void test() {
		log.info("我是[{}]", this.getClass().getName());
	}

	@Override
	public void testDoubleIf(Integer code) {
		log.info("结果为[{}]",userMapper.testDoubleIf(code));
	}
}
