package com.daop.msc.payment.service;

import com.daop.msc.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.payment.service
 * @Description:
 * @DATE: 2020-10-20
 * @AUTHOR: Administrator
 **/
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
