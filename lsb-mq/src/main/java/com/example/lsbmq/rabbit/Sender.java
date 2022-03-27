package com.example.lsbmq.rabbit;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description:
 * @Author: boolean
 * @Date: 2020/1/6 21:38
 */
@Component
public class Sender {
    public static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend("hello", context);
    }

    private static String TOPIC = "DemoTopic";
    private static String TAGS = "glmapperTags";
    @Autowired
    private DefaultMQProducer defaultMQProducer;
    public String testRocketMQ() throws Throwable {
        Message msg = new Message(TOPIC, TAGS, ("Say Hello RocketMQ to Glmapper").getBytes(RemotingHelper.DEFAULT_CHARSET));
        // 调用客户端发送消息
        SendResult sendResult = defaultMQProducer.send(msg);
        LOGGER.info("sendResult: {}.",sendResult);
        return "SUCCESS";
    }

}



