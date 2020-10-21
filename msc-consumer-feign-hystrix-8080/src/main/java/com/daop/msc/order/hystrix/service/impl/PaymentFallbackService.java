package com.daop.msc.order.hystrix.service.impl;

import com.daop.msc.order.hystrix.service.PaymentHystrixService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: springboot-cloud
 * @BelongsPackage: com.daop.msc.order.hystrix.service.impl
 * @Description:
 * @DATE: 2020-10-21 23:27
 * @AUTHOR: Daop
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfoOk ┭┮﹏┭┮";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "---- Payment Fallback Service fall back-paymentTimeout ┭┮﹏┭┮";
    }
}
