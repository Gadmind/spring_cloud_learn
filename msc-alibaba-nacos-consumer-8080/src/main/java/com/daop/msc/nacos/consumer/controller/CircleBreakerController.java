package com.daop.msc.nacos.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.daop.msc.entities.CommonResult;
import com.daop.msc.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @BelongsProject: springboot-cloud
 * @BelongsPackage: com.daop.msc.nacos.consumer.controller
 * @Description:
 * @DATE: 2020-10-27 00:23
 * @AUTHOR: Daop
 **/
@RestController
@Slf4j
public class CircleBreakerController {
    @Value("${service-url.nacos-user-service}")
    private String serverUrl;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")//没有配置 返回error页面
    //@SentinelResource(value = "fallback", fallback = "handlerFallback") //fallback负责业务异常
    //@SentinelResource(value = "fallback", blockHandler = "blockHandler")//blockHandler只负责Sentinel控制台配置违规
    //@SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler")//blockHandler只负责Sentinel控制台配置违规
    @SentinelResource(value = "fallback",
            fallback = "handlerFallback",
            blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})//忽略异常配置
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(serverUrl + "/nacos/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常");
        } else if (result.getData() == null) {
            throw new NullPointerException("该ID没有对应记录，空指针异常");
        }
        return result;
    }

    /**
     * fallback回调函数
     *
     * @param id
     * @param e
     * @return
     */
    public CommonResult handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, null);
        return new CommonResult(444, "兜底异常handlerFallback，Exception内容 " + e.getMessage(), payment);
    }

    /**
     * BlockHandler处理
     *
     * @param id
     * @param e
     * @return
     */
    public CommonResult blockHandler(@PathVariable Long id, BlockException e) {
        Payment payment = new Payment(id, null);
        return new CommonResult(445, "blockHandler-sentinel限流，无此流水：BlockException  " + e.getMessage(), payment);
    }
}
