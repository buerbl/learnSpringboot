package com.example.crud.service.impl;

import com.example.crud.entity.Name;
import com.example.crud.mapper.NameMapper;
import com.example.crud.service.INameService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-10-12
 */
@Service
public class NameServiceImpl extends ServiceImpl<NameMapper, Name> implements INameService {

	@Resource
	private NameMapper nameMapper;

	@Autowired
	private TestService testService;

	@Override
	public Name getById(Name name) {
		return nameMapper.getById(name);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void localUpdate(Name name) {
		updateById(name);
		testService.test1(name);
	}
}
