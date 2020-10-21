package com.daop.msc.order.hystrix.controller;

import com.daop.msc.order.hystrix.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: springboot-cloud
 * @BelongsPackage: com.daop.msc.order.hystrix.controller
 * @Description:
 * @DATE: 2020-10-21 22:17
 * @AUTHOR: Daop
 **/
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfoOk(id);
    }

    @GetMapping("/timeout/{id}")
   /* @HystrixCommand(fallbackMethod = "paymentTimeoutHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})*/
//    @HystrixCommand
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfoTimeout(id);
    }

    public String paymentTimeoutHandler(@PathVariable("id") Integer id) {
        return "我是消费者，支付系统繁忙或自身系统运行出错，稍后重试";
    }

    //    全局FallBack
    public String paymentGlobalFallbackMethod() {
        return "Global异常处理信息，请稍后重试";
    }
}
