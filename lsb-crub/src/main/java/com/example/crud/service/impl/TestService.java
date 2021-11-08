package com.example.crud.service.impl;

import com.example.crud.entity.Name;
import com.example.crud.mapper.NameMapper;
import com.example.crud.service.AsyncService;
import com.example.crud.service.INameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

/**
 * @Author buerbl
 * @create 2020/9/10 13:52
 */
@Slf4j
@Service
public class TestService {
	@Autowired
	private AsyncService asyncService;

	@Autowired
	private INameService nameService;

	@Resource
	private NameMapper nameMapper;


	public void test(){
		log.info("开始");
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		asyncService.test();
		stopWatch.stop();
		log.info("时间为[{}]", stopWatch.getTotalTimeMillis());
		log.info("结束");
	}

//	@Transactional(rollbackFor = Exception.class)
	public void test1(Name name){
		nameMapper.updateById(name);
		log.info("1111");
	}

}
