package com.daop.msc.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.daop.msc.entities.CommonResult;
import com.daop.msc.entities.Payment;
import com.daop.msc.sentinel.myhandler.CustomBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: springboot-cloud
 * @BelongsPackage: com.daop.msc.sentinel.controller
 * @Description:
 * @DATE: 2020-10-26 23:04
 * @AUTHOR: Daop
 **/
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handlerException")
    public CommonResult byResource() {
        return new CommonResult(200, "按照资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public CommonResult handlerException(BlockException e) {
        return new CommonResult(444, e.getClass().getCanonicalName() + "\t服务不可用");
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按照URL限流测试OK", new Payment(2020L, "serial001"));
    }

    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomBlockHandler.class,
            blockHandler = "handlerException2"
    )
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按客户自定义限流测试OK", new Payment(2020L, "serial001"));
    }

}
