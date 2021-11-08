package com.example.crud;

import com.example.crud.entity.Name;
import com.example.crud.entity.User;
import com.example.crud.service.AsyncService;
import com.example.crud.service.INameService;
import com.example.crud.service.impl.CompentServiceImplTotal;
import com.example.crud.service.impl.TestService;
import com.example.crud.service.impl.UserJDBCServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author buerbl
 * @create 2020/9/10 13:02
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTest {
	@Autowired
	private TestService test;

	@Autowired
	private INameService nameService;

	@Test
	public void test()  {
		try {
			test.test();
		} catch (Exception e) {
			log.error("错误为[{}] ", e);
		}
	}

	@Test
	public void test1(){
		Name name = new Name();
		name.setId(1);
		nameService.getById(name);
	}

	@Test
	public void test2(){
		Name name = new Name();
		name.setId(19);
		name.setName("wen61123");
//		nameService.localUpdate(name);
		test.test1(name);
	}

	@Autowired
	private CompentServiceImplTotal compentServiceImplTotal;
	@Test
	public void testStrategy(){
		compentServiceImplTotal.strategySelect("compentServiceImplTwo").test("123");
	}

	@Autowired
	private UserJDBCServiceImpl userJDBCService;
	@Test
	public void testJdbc(){
		User user = new User();
		user.setUsername("chen1");
		user.setAddress("shenzhen1");
		userJDBCService.addUser(user);
	}
}
