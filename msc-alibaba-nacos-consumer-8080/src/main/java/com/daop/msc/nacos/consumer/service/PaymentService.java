package com.daop.msc.nacos.consumer.service;

import com.daop.msc.entities.CommonResult;
import com.daop.msc.entities.Payment;
import com.daop.msc.nacos.consumer.service.impl.PaymentFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.nacos.consumer.service
 * @Description:
 * @DATE: 2020-10-27
 * @AUTHOR: Administrator
 **/
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackServiceImpl.class)
public interface PaymentService {
    @GetMapping("/nacos/{id}")
    public CommonResult<Payment> getPaymentBySQL(@PathVariable("id") Long id);
}
