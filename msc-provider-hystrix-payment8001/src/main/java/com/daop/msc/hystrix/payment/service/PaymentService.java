package com.daop.msc.hystrix.payment.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sun.org.apache.bcel.internal.generic.I2F;
import org.springframework.cloud.netflix.hystrix.HystrixProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: springboot-cloud
 * @BelongsPackage: com.daop.msc.hystrix.payment.service
 * @Description:
 * @DATE: 2020-10-21 21:31
 * @AUTHOR: Daop
 **/
@Service
public class PaymentService {

    public String paymentInfoOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfoOk,id: " + id + "\tO(∩_∩)O";
    }

    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
    public String paymentTimeout(Integer id) {
//        int a = 10 / 0;
        int timeNumber = 13000;
        //暂停线程3秒
        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentTimeout,id: " + id + "\tO(∩_∩)O耗时" + timeNumber + "秒钟";
//        return "线程池：" + Thread.currentThread().getName() + " paymentTimeout,id: " + id + "\tO(∩_∩)O";
    }

    public String paymentTimeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " 8001系统繁忙或程序出错，稍后重试,id: " + id + "\t ┭┮﹏┭┮";
    }

    //==============服务熔断==============
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",
            commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败阈值
            })
    public String paymentCircuitBreaker(@PathVariable Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功 流水号：" + serialNumber;
    }

    public String paymentCircuitBreakerFallback(@PathVariable Integer id) {
        return "id不能为负数，请稍后重试，/(ㄒoㄒ)/~~ id：" + id;
    }

}
