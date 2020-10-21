package com.daop.msc.order.hystrix.service;

import com.daop.msc.order.hystrix.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @BelongsProject: springboot-cloud
 * @BelongsPackage: com.daop.msc.order.hystrix.service
 * @Description:
 * @DATE: 2020-10-21 22:16
 * @AUTHOR: Daop
 **/
@Component
@FeignClient(value = "MSC-PAYMENT-HYSTRIX-SERVICE",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id);
}
