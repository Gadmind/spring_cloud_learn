package com.daop.msc.order.feign.service;

import com.daop.msc.entities.CommonResult;
import com.daop.msc.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.order.feign.service
 * @Description:
 * @DATE: 2020-10-21
 * @AUTHOR: Administrator
 **/
@Component
@FeignClient(value = "MSC-PAYMENT-SERVICE")
@RequestMapping("/payment")
public interface PaymentFeignService {
    @GetMapping("/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
