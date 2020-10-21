package com.daop.msc.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.payment
 * @Description: 启动类
 * @DATE: 2020-10-20
 * @AUTHOR: Administrator
 **/
@SpringBootApplication
@EnableEurekaClient
public class PaymentApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8002.class, args);
    }
}
