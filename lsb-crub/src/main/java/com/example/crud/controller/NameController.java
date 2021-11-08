package com.example.crud.controller;


import com.example.crud.entity.Name;
import com.example.crud.service.INameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-10-12
 */
@RestController
@RequestMapping("/name")
@Slf4j
public class NameController {
	@Autowired
	private INameService nameService;

	@RequestMapping("/test")
	public Name test(){
		return nameService.getById(1);
	}


	@RequestMapping("/add")
	public String add(){
		Name name = new Name();
		name.setName("chen");
		try {
			return nameService.save(name)?"1":"0";
		}catch (DuplicateKeyException e){
			log.error("重复了,报错:", e);
			return "重复了";
		}catch (Exception e){
			log.error("报错", e);
			return "报错";
		}
	}
}

