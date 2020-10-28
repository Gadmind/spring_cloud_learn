package com.daop.msc.seata.order.controller;

import com.daop.msc.entities.CommonResult;
import com.daop.msc.entities.Order;
import com.daop.msc.seata.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.seata.order.controller
 * @Description:
 * @DATE: 2020-10-27
 * @AUTHOR: Administrator
 **/
@RestController
public class OrderController {

    private static final String ORDER_URL_PREFIX = "/order";

    @Autowired
    private OrderService orderService;

    @GetMapping(ORDER_URL_PREFIX + "/create")
    public CommonResult creatOrder(Order order) {
        orderService.creatOrder(order);
        return new CommonResult(200, "订单创建成功",order);
    }
}
