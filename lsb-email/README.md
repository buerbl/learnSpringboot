>show me the code and talk to me,做的出来更要说的明白  
>我是布尔bl，你的支持是我分享的动力！


##  1 引入

简单送送邮件

# 2 结构
```java
├─java
│  └─com
│      └─example
│          └─lsbemail
└─resources
    ├─static
    └─templates
```
## 3 maven
```java
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```
## 4 配置

```java
## 邮箱服务器地址
spring.mail.host=smtp.163.com
## 用户名
spring.mail.username=18319748706@163.com
##163的授权密码（需要额外获取）
spring.mail.password=*
spring.mail.default-encoding=utf-8
## 发送地址
mail.sender=18319748706@163.com
## 接收地址
mail.receiver=18319748706@163.com
```

## 5 发送

```java
package com.example.lsbemail;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
@Data
public class LsbEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsbEmailApplication.class, args);
    }

    @Value("${mail.sender}")
    private String sender;

    @Value("${mail.receiver}")
    private String receiver;

    @Autowired
    private JavaMailSender javaMailSender;
    @RequestMapping("/send")
    public void send(){
        String title = "文本邮件";
        String text = "文本内容";
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setTo(receiver);
        simpleMailMessage.setSubject(title);
        simpleMailMessage.setText(text);
        try {
            javaMailSender.send(simpleMailMessage);
        }catch (Exception e){
            log.error("邮件发送失败",e);
        }
    }
}

```

### 6 关注微信公众号，随时移动端阅读

![](http://javahouse.xyz/20200106104817.png)
