package com.daop.msc.stream.rabbitmq.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.stream.rabbitmq.consumer.controller
 * @Description:
 * @DATE: 2020-10-23
 * @AUTHOR: Administrator
 **/
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者一号，收到消息--------》" + message.getPayload() + "\t" + serverPort);
    }
}
