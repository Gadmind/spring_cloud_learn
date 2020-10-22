package com.daop.msc.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.gateway
 * @Description:
 * @DATE: 2020-10-22
 * @AUTHOR: Administrator
 **/
@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication9527.class, args);
    }
}
