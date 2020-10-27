package com.daop.msc.seata.order.service.impl;

import com.daop.msc.entities.Order;
import com.daop.msc.seata.order.mapper.OrderMapper;
import com.daop.msc.seata.order.service.AccountService;
import com.daop.msc.seata.order.service.OrderService;
import com.daop.msc.seata.order.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.seata.order.service.impl
 * @Description:
 * @DATE: 2020-10-27
 * @AUTHOR: Administrator
 **/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private StorageService storageService;
    @Autowired
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户余额扣减余额->修改订单状态
     * 下订单->减库存->减余额->改状态
     * @param order 订单
     */
    @Override
    public void creatOrder(Order order) {

        log.info("------> 开始新建订单");
        //1.新建订单
        orderMapper.createOrder(order);

        log.info("------> 订单微服务开始调用库存服务，做扣减Count");
        //2.扣减库存
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("------> 订单微服务调用库存服务做扣减逻辑结束");

        log.info("------> 订单微服务开始调用账户服务，做扣减Money");
        //3.扣减余额
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("------> 订单微服务调用账户服务做扣减逻辑结束");

        log.info("------> 修改订单状态开始");
        //4.修改订单状态
        orderMapper.updateOrder(order.getId(),0);
        log.info("------> 修改订单状态结束");

        log.info("------> 下订单结束 <------");
    }
}
