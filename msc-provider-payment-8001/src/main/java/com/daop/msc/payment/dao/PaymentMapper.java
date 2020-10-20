package com.daop.msc.payment.dao;

import com.daop.msc.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.payment.dao
 * @Description:
 * @DATE: 2020-10-20
 * @AUTHOR: Administrator
 **/
@Mapper
public interface PaymentMapper {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
