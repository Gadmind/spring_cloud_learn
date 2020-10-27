package com.daop.msc.seata.order.mapper;

import com.daop.msc.entities.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.seata.order.mapper
 * @Description:
 * @DATE: 2020-10-27
 * @AUTHOR: Administrator
 **/
@Mapper
public interface OrderMapper {
    /**
     * 创建订单
     * @param order
     */
    void createOrder(Order order);

    /**
     * 修改订单状态
     * @param id
     * @param status
     */
    void updateOrder(@Param("id") Long id, @Param("status") Integer status);
}
