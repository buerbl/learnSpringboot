package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

@SpringBootApplication(scanBasePackages = {"org.jeecg.modules.jmreport"})
@MapperScan(value={"org.jeecg.modules.jmreport.**.mapper*"})
public class Application
{
    public static void main( String[] args ) {
        SpringApplication.run(Application.class, args);
    }
}
