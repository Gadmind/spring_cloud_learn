package com.daop.msc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.payment.entities
 * @Description:
 * @DATE: 2020-10-20
 * @AUTHOR: Administrator
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
