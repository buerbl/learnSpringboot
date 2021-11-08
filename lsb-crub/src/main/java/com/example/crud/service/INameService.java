package com.example.crud.service;

import com.example.crud.entity.Name;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-10-12
 */
public interface INameService extends IService<Name> {

	Name getById(Name name);

	void localUpdate(Name name);
}
