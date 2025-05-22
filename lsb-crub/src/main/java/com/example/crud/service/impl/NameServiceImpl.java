package com.example.crud.service.impl;

import com.example.crud.entity.Name;
import com.example.crud.entity.People;
import com.example.crud.mapper.NameMapper;
import com.example.crud.mapper.PeopleMapper;
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

	@Autowired
	private PeopleMapper peopleMapper;

	@Autowired
	private INameService nameService;

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

	@Override
	public void AddName() {
//		nameService.addPeople();
		addPeople();
	}

	@Transactional(rollbackFor = Exception.class)
	public void addPeople() {
		People people = new People();
		people.setName("赵六");
		people.setAdress("北京");
		people.setSex("男");
		peopleMapper.insert(people);
		int i = 1 / 0;

	}
}
