package com.daop.msc.nacos.consumer.controller;

import com.daop.msc.entities.CommonResult;
import com.daop.msc.entities.Payment;
import com.daop.msc.nacos.consumer.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.nacos.consumer.controller
 * @Description:
 * @DATE: 2020-10-27
 * @AUTHOR: Administrator
 **/
@RestController
public class OpenfeignTestController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/{id}")
    public CommonResult<Payment> getPaymentBySQL(@PathVariable("id") Long id) {
        return paymentService.getPaymentBySQL(id);
    }

}
