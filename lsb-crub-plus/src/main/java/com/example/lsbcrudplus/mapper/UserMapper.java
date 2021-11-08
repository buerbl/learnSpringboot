package com.example.lsbcrudplus.mapper;

import com.example.lsbcrudplus.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-12-09
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
