package com.daop.msc.nacos.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.nacos.consumer
 * @Description:
 * @DATE: 2020-10-26
 * @AUTHOR: Administrator
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosApplication8080 {
    public static void main(String[] args) {
        SpringApplication.run(NacosApplication8080.class, args);
    }
}
