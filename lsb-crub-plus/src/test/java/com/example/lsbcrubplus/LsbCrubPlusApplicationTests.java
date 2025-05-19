package com.example.lsbcrubplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.lsbcrudplus.LsbCrubPlusApplication;
import com.example.lsbcrudplus.entity.User;
import com.example.lsbcrudplus.service.IUserService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LsbCrubPlusApplication.class)
public class LsbCrubPlusApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setAddress("shenzhen");
        user.setName("chen");
        user.setPassword("123");
        user.setStatus(1);
        boolean save = userService.save(user);
        log.info(String.valueOf(save));
    }

    /**
     * 测试count查询
     */
    @Test
    public void test(){
        int count = userService.count();
        log.info("cout的结果是[{}]",count);
    }

    /**
     *  SELECT adress,status,id FROM user WHERE (id = ? AND adress = ?) GROUP BY adress
     */
    @Test
    public void testQuery(){
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.select(User::getAddress, User::getStatus, User::getId)
                .eq(User::getId, "1")
                .eq(User::getAddress, "ss")
                .groupBy(User::getAddress);
        List<User> list = userService.list(lambdaQuery);
        log.info("list的结果{}", list);
    }

    /**
     * 分页查询
     * SELECT adress,status,id FROM user WHERE (adress = ?) LIMIT ?,?
     *
     * 中国(String), 18(Long), 6(Long)
     */
    @Test
    public void testPage(){
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.select(User::getAddress, User::getStatus, User::getId)
                .eq(User::getAddress, "中国");
        IPage<User> page = new Page<>(4, 6);   // 第一个参数表示页树，第二个表示每页多少行
        IPage<User> page1 = userService.page(page,lambdaQuery);
        log.info("page的结果是{}", page1);
    }

    @Test
    /**
     * 测试不等于
     */
    public void testNe(){
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.select(User::getId, User::getName, User::getAddress)
                .ne(User::getId, "1")
                .last("limit 10");
        List<User> list = userService.list(lambdaQuery);
        log.info("结果为{}", list);
    }

    @Test
    public void testIn(){
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.select(User::getId, User::getName, User::getAddress)
                .in(User::getId, 1, 3, 4);
        List<User> list = userService.list(lambdaQuery);
        log.info("结果为{}", new Gson().toJson(list));

    }


}
