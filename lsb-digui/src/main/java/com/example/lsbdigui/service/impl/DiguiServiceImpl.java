package com.example.lsbdigui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lsbdigui.entity.Digui;
import com.example.lsbdigui.mapper.DiguiMapper;
import com.example.lsbdigui.service.IDiguiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-15
 */
@Service
public class DiguiServiceImpl extends ServiceImpl<DiguiMapper, Digui> implements IDiguiService {


    //应用层递归查询
    @Override
    public List<Digui> getAll(int parent) {
        List<Digui> deptVosList=new ArrayList<>();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("parentid", parent);
        List<Digui> list1 = list(queryWrapper);
        for (Digui digui: list1) {
            Digui digui1 = new Digui();
            digui1.setId(digui.getId());
            digui1.setMsg(digui.getMsg());
            digui1.setParentid(digui.getParentid());
            digui1.setDiguiList(getAll(digui.getId()));
            deptVosList.add(digui1);
        }
        return deptVosList;

    }

    //SQL层递归查询
    @Override
    public List<Digui> getAllBySQL(Integer parent) {
        return baseMapper.getAllBySQL(parent);
    }
}
