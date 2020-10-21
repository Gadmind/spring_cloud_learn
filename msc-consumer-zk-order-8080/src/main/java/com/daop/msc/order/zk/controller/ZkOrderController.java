package com.daop.msc.order.zk.controller;

import com.daop.msc.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.zk.order.controller
 * @Description:
 * @DATE: 2020-10-21
 * @AUTHOR: Administrator
 **/
@RestController
@RequestMapping("/consumer/payment")
public class ZkOrderController {
    public static final String INVOKE_URL = "http://msc-payment-service/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/zk")
    public String paymentInfo(Payment payment) {
        return restTemplate.postForObject(INVOKE_URL + "payment/zk", payment, String.class);
    }
}
