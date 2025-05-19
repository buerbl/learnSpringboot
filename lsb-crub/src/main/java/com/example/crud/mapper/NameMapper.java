package com.example.crud.mapper;

import com.example.crud.entity.Name;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-10-12
 */
public interface NameMapper extends BaseMapper<Name> {

	Name getById( Name name);
}
