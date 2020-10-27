package com.daop.msc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Storage {
    private Long id;
    /**
     * 产品ID
     */
    private Long productId;
    /**
     * 总库存
     */
    private Integer total;
    /**
     * 已用库存
     */
    private Integer used;
    /**
     * 剩余库存
     */
    private Integer residue;
}
