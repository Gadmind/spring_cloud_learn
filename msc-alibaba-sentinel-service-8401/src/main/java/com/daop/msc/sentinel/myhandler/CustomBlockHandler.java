package com.daop.msc.sentinel.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.daop.msc.entities.CommonResult;

/**
 * @BelongsProject: springboot-cloud
 * @BelongsPackage: com.daop.msc.sentinel.myhandler
 * @Description:
 * @DATE: 2020-10-26 23:30
 * @AUTHOR: Daop
 **/
public class CustomBlockHandler {
    public static CommonResult handlerException(BlockException e) {
        return new CommonResult(444, "按客户自定义限流测试OK, Global HandlerException-----1");
    }
    public static CommonResult handlerException2(BlockException e) {
        return new CommonResult(444, "按客户自定义限流测试OK, Global HandlerException-----2");
    }
}
