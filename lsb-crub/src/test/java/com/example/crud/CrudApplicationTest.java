package com.example.crud;

import com.example.crud.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudApplicationTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testDoubleIf() {
        userService.testDoubleIf(2);
    }

    @Test
    public void test(){
        userService.test();
    }
}
