package com.example.lsbdigui.controller;


import com.example.lsbdigui.service.IDiguiService;
import com.example.lsbdigui.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-15
 */
@RestController
@RequestMapping("/digui")
public class DiguiController {
    @Autowired
    private IDiguiService diguiService;

    @RequestMapping("/getAll")
    public Result getAll(){
        return Result.getResult(diguiService.getAll(0));
    }

    @RequestMapping("/getAllBySQL")
    public Result getAllBySQL(){
        return Result.getResult(diguiService.getAllBySQL(null));
    }
}

