package com.example.crud.service;

import com.example.crud.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.lang.Nullable;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-06
 */
public interface IUserService extends IService<User> {
	void test();

	void testDoubleIf(Integer code);

	@Nullable
	void testDoubleIf(Integer code, Integer code2);
}
