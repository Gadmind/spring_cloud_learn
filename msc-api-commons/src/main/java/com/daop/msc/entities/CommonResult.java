package com.daop.msc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.payment.entities
 * @Description: 统一结果返回
 * @DATE: 2020-10-20
 * @AUTHOR: Administrator
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
