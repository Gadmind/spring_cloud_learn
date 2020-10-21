package com.daop.msc.hystrix.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @BelongsProject: springboot-cloud
 * @BelongsPackage: com.daop.msc.hystrix.payment
 * @Description: 启动类
 * @DATE: 2020-10-21 21:28
 * @AUTHOR: Daop
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HystrixApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication8001.class,args);
    }
}
