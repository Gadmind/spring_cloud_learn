package com.daop.msc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.entities
 * @Description:
 * @DATE: 2020-10-27
 * @AUTHOR: Administrator
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    /**
     * 订单状态 0创建中；1已完结
     */
    private Integer status;
}
