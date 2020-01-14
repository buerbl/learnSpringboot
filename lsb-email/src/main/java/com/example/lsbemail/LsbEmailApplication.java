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
