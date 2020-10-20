package com.daop.msc.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.order
 * @Description: 启动类
 * @DATE: 2020-10-20
 * @AUTHOR: Administrator
 **/
@SpringBootApplication
@EnableEurekaClient
public class OrderApplication8080 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication8080.class, args);
    }
}
