package com.example.crud.mapper;

import com.example.crud.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
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

	Map<Integer,String> testDoubleIf1(Integer code, Integer code2);

	String testStringForLong(Long id);

	Integer asdas(@Param("id") Integer id);

	Integer batchInsert(List<Integer> integers);
}
