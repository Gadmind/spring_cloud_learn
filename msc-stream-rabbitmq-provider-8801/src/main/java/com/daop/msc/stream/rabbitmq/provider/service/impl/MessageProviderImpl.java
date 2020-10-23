package com.daop.msc.stream.rabbitmq.provider.service.impl;

import com.daop.msc.stream.rabbitmq.provider.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.stream.rabbitmq.provider.service.impl
 * @Description:
 * @DATE: 2020-10-23
 * @AUTHOR: Administrator
 **/
@EnableBinding(Source.class)//定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {
    //消息发送通道
    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("推送的消息***serial: " + serial);
        return null;
    }
}
