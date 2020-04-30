package com.example.lsbdigui.mapper;

import com.example.lsbdigui.entity.Digui;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-12-15
 */
public interface DiguiMapper extends BaseMapper<Digui> {

    List<Digui> getAllBySQL(@Param("parent")Integer parent);
}
