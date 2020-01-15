package com.example.lsbdruid.service.impl;

import com.example.lsbdruid.entity.MyUser;
import com.example.lsbdruid.mapper.MyUserMapper;
import com.example.lsbdruid.service.IMyUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-01-15
 */
@Service
public class MyUserServiceImpl extends ServiceImpl<MyUserMapper, MyUser> implements IMyUserService {

}
