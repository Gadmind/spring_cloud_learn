package com.daop.msc.seata.order.service;

import com.daop.msc.entities.Order;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.seata.order.service.impl
 * @Description:
 * @DATE: 2020-10-27
 * @AUTHOR: Administrator
 **/
public interface OrderService {
    void creatOrder(Order order);

}
