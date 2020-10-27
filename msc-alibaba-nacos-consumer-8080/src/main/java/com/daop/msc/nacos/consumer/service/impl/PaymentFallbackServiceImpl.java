package com.daop.msc.nacos.consumer.service.impl;

import com.daop.msc.entities.CommonResult;
import com.daop.msc.entities.Payment;
import com.daop.msc.nacos.consumer.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.nacos.consumer.service.impl
 * @Description:
 * @DATE: 2020-10-27
 * @AUTHOR: Administrator
 **/
@Component
public class PaymentFallbackServiceImpl implements PaymentService {
    @Override
    public CommonResult<Payment> getPaymentBySQL(Long id) {
        return new CommonResult<>(444, "服务降级返回，-----PaymentFallbackServiceImpl", new Payment(id, "errorSerial"));
    }
}
