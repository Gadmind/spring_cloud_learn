package com.daop.msc.order.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.order.consul
 * @Description:
 * @DATE: 2020-10-21
 * @AUTHOR: Administrator
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulOrderApplication8080 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulOrderApplication8080.class, args);
    }
}
