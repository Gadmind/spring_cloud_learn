package com.daop.msc.payment.service.impl;

import com.daop.msc.entities.Payment;
import com.daop.msc.payment.dao.PaymentMapper;
import com.daop.msc.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.payment.service.impl
 * @Description:
 * @DATE: 2020-10-20
 * @AUTHOR: Administrator
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
