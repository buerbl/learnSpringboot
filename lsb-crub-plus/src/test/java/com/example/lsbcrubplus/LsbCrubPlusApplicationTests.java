package com.example.lsbcrubplus;

import com.example.lsbcrudplus.LsbCrubPlusApplication;
import com.example.lsbcrudplus.entity.User;
import com.example.lsbcrudplus.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest(classes = LsbCrubPlusApplication.class)
public class LsbCrubPlusApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    public void contextLoads() {
        List<User> userList = new ArrayList<>();
        User user = new User();
        User user1 = new User();
        user.setId(1L);
        user.setAdress("shenzhen");
        user.setName("chen");
        user.setPassword("123");
        user.setStatus(1);

//        userService.updateBatchById()
        boolean save = userService.save(user);
        log.info(String.valueOf(save));
    }

}
