package com.daop.msc.stream.rabbitmq.provider.controller;

import com.daop.msc.stream.rabbitmq.provider.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.stream.rabbitmq.provider.controller
 * @Description:
 * @DATE: 2020-10-23
 * @AUTHOR: Administrator
 **/
@RestController
public class SendController {
    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/sendMsg")
    public String sendMessage() {
        return messageProvider.send();
    }
}
