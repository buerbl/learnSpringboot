package com.example.lsbcrudplus.service;

import com.example.lsbcrudplus.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-09
 */
public interface IUserService extends IService<User> {

    Boolean saveOne();
}
