package com.example.crud;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.List;
@Slf4j
@Data
public class User {
    private Integer sex;
    private String name;
    private List<Clothes> clothesList;


    @Test
    public void test() {
        User user = JSON.parseObject(" {\n" +
                "            \"sex\": 0,\n" +
                "                \"name\": \"chen\",\n" +
                "                \"clothesList\": [\n" +
                "            {\n" +
                "                \"color\": \"red\"\n" +
                "            }\n" +
                "  ]\n" +
                "        }", User.class);
        log.info(user.toString());
        log.info("==========================================");
        User1 target = new User1();
        BeanUtils.copyProperties(user, target);
        log.info(target.toString());
    }
}
