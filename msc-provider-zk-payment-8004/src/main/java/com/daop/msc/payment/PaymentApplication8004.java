package com.daop.msc.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.payment
 * @Description: 向zookeeper注册中心注册服务
 * @DATE: 2020-10-21
 * @AUTHOR: Administrator
 * 注解@EnableDiscoveryClient用于向Consul或者Zookeeper作为注册中心时注册服务
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8004.class, args);
    }
}
