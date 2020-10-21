package com.daop.msc.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.payment.controller
 * @Description:
 * @DATE: 2020-10-21
 * @AUTHOR: Administrator
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/consul")
    public String paymentZK() {
        return "SpringCloud with Consul: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}