package com.example.crud;

import com.example.crud.mapper.UserMapper;
import com.example.crud.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;
import sun.security.krb5.internal.PAForUserEnc;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudApplicationTest {

	@Autowired
	private IUserService userService;


	@Resource
	private UserMapper userMapper;

	@Test
	public void testDoubleIf() {
		userService.testDoubleIf(2);
	}

	@Test
	public void test() {
		userService.test();
	}

	@Test
	public void test3()  {
		StopWatch sw = new StopWatch();

		sw.start("校验耗时");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sw.stop();

		sw.start("组装报文耗时");

		sw.start("请求耗时");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sw.stop();

		System.out.println(sw.getTotalTimeMillis());
	}


	@Test
	public void testStringForLong(){
		userMapper.testStringForLong(2L);
	}
}