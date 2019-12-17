package com.example.lsbdigui.service;

import com.example.lsbdigui.entity.Digui;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.lsbdigui.util.Result;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-15
 */
public interface IDiguiService extends IService<Digui> {

    /**
     * 应用层按照顺序返回所有的内容
     * @return
     */
    List<Digui> getAll(int parent);


    /**
     * SQL层按照顺序返回所有的内容
     * @return
     */
    List<Digui> getAllBySQL(int parent);


}
