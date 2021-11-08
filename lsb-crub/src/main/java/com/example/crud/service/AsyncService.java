package com.example.crud.service;

import com.example.crud.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author buerbl
 * @create 2020/9/10 12:54
 */
@Slf4j
@Service
public class AsyncService {
	@Resource
	private UserMapper userMapper;
	@Async
	public void test()  {
		int a = 1000000; //指定为100
		int times = 25000;
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < times; i ++){
			int num = new Random().nextInt(a);
			arrayList.add(num);
		}
		List<Integer> integerList = arrayList.stream().distinct().collect(Collectors.toList());
		log.info("去重的后大小[{}]", integerList.size());
//		for (int i = 0; i < integerList.size(); i++){
//				userMapper.asdas(integerList.get(i));
//		}




		try {
			//切割插入，控制每次插入的数量 建议：100条/次  by JASON on 20190912
			int count = integerList.size();
			for (int i = 0; i < count; i+= 100) {
				if (i+100 <= count){
					userMapper.batchInsert(integerList.subList(i, i+100));
				}else {
					userMapper.batchInsert(integerList.subList(i, count));
				}
			}
		}catch (DuplicateKeyException e){
			//备注：此处加异常机制是针对trade_seat_status的唯一约束的处理。
			log.error("trade_seat_status 插入动态座位图异常,座位图已经存在",e.getCause());
		}


	}

	private synchronized void test1(){
		int a = 1000000; //指定为100
		int times = 2000;
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < 10; i ++){
			int num = new Random().nextInt(a);
			arrayList.add(num);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		log.info("当前线程为[{}]", Thread.currentThread().getName());
//		log.info("生成的随机数集合大小为[{}]",arrayList.size());
//		List<Integer> integerList = arrayList.stream().distinct().collect(Collectors.toList());
//		log.info("去重后的随机数集合大小为[{}]", integerList.size());
	}
}
