package com.example.lsbrestful;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class LsbRestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsbRestfulApplication.class, args);
    }

    @RequestMapping(value = "/v1/list",method = RequestMethod.GET)
    public String getList(){
        log.info("得到列表");
        return "得到列表";
    }

    @RequestMapping(value = "/v1/list/{name}",method = RequestMethod.GET)
    public String getListone(@PathVariable("name") String name){
        log.info("得到列表"+name);
        return "得到列表"+name;
    }

    @RequestMapping(value = "/v1/list",method = RequestMethod.POST)
    public String addList(){
        log.info("增加一个列表1");
        return "增加一个列表1";
    }

    @RequestMapping(value = "/v1/list",method = RequestMethod.DELETE)
    public String delList(){
        log.info("删除一个列表");
        return "删除一个列表";
    }
}
