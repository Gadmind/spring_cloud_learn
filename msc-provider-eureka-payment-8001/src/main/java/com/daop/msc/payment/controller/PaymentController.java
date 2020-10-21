package com.daop.msc.payment.controller;

import com.daop.msc.entities.CommonResult;
import com.daop.msc.entities.Payment;
import com.daop.msc.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.payment.controller
 * @Description:
 * @DATE: 2020-10-20
 * @AUTHOR: Administrator
 **/
@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*******element: " + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("MSC-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }


    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功，serverPort：" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功，serverPort：" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID：" + id);
        }
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}