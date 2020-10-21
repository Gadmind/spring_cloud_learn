package com.daop.msc.order.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @BelongsProject: springboot-cloud
 * @BelongsPackage: com.daop.msc.order.hystrix
 * @Description: 启动类
 * @DATE: 2020-10-21 22:13
 * @AUTHOR: Daop
 **/
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixOrderApplication8080 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixOrderApplication8080.class, args);
    }
}
