>show me the code and talk to me,做的出来更要说的明白  
>我是布尔bl，你的支持是我分享的动力！


## 1 引入

数据库查询怎样把控？我们怎么知道自己写的 sql 语有没有问题？接入 druid 即可

## 2 引入依赖

```java
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid-spring-boot-starter</artifactId>
    <version>1.1.17</version>
</dependency>
```

## 3 编写配置
```java
# 连接配置
spring.datasource.druid.url= jdbc:mysql://ip/数据库
spring.datasource.druid.username= *
spring.datasource.druid.password= *
spring.datasource.druid.driver-class-name= com.mysql.jdbc.Driver

## 连接池配置
spring.datasource.druid.initial-size=5
spring.datasource.druid.max-active=20
spring.datasource.druid.min-idle=5
spring.datasource.druid.max-wait=3000
spring.datasource.druid.pool-prepared-statements=true
spring.datasource.druid.max-pool-prepared-statement-per-connection-size=5
# spring.datasource.druid.max-open-prepared-statements= #等价于上面的max-pool-prepared-statement-per-connection-size
spring.datasource.druid.validation-query=select 1
spring.datasource.druid.validation-query-timeout=1
spring.datasource.druid.test-on-borrow=true
spring.datasource.druid.test-on-return=true
spring.datasource.druid.test-while-idle=true
spring.datasource.druid.time-between-eviction-runs-millis=10000
spring.datasource.druid.min-evictable-idle-time-millis=30001
spring.datasource.druid.async-close-connection-enable=true

# WebStatFilter配置，说明请参考Druid Wiki，配置_配置WebStatFilter
spring.datasource.druid.web-stat-filter.enabled= true
spring.datasource.druid.web-stat-filter.url-pattern=/*
spring.datasource.druid.web-stat-filter.exclusions=*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*


# StatViewServlet配置，说明请参考Druid Wiki，配置_StatViewServlet配置
spring.datasource.druid.stat-view-servlet.enabled= true
spring.datasource.druid.stat-view-servlet.url-pattern=/druid/*
spring.datasource.druid.stat-view-servlet.reset-enable= false
# 自定义
spring.datasource.druid.stat-view-servlet.login-username=root
spring.datasource.druid.stat-view-servlet.login-password=123
# 显示sql统计
spring.datasource.druid.filter.stat.enabled=true
# Spring监控配置，说明请参考Druid Github Wiki，配置_Druid和Spring关联监控配置
spring.datasource.druid.aop-patterns= com.example.lsbdruid.service.*
```
## 4 测试代码
```java
package com.example.lsbdruid.controller;


import com.example.lsbdruid.entity.MyUser;
import com.example.lsbdruid.service.IMyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-01-15
 */
@RestController
@RequestMapping("/my-user")
public class MyUserController {
    @Autowired
    private IMyUserService myUserService;
    @RequestMapping("/add")
    public String add(){
        MyUser myUser = new MyUser();
        myUser.setAge(18);
        myUser.setEmail("83");
        myUser.setName("布尔bl");
        return myUserService.save(myUser) ? "1": "0";
    }

    @RequestMapping("/get")
    public List<MyUser> get(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myUserService.list();
    }

}


```


### 5 启动

 jar方式启动，直接点击启动类 mian() 方法启动

###  6 关注微信公众号，随时移动端阅读

![](http://javahouse.xyz/20200106104817.png)
