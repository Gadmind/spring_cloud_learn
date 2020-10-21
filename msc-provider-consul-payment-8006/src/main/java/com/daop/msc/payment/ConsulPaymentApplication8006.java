package com.daop.msc.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.payment
 * @Description:
 * @DATE: 2020-10-21
 * @AUTHOR: Administrator
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulPaymentApplication8006 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulPaymentApplication8006.class, args);
    }
}
