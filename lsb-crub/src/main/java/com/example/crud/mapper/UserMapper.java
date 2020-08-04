package com.example.crud.mapper;

import com.example.crud.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-12-06
 */
public interface UserMapper extends BaseMapper<User> {
	@MapKey("id")
	Map<Integer, String> testDoubleIf(Integer code);
}
