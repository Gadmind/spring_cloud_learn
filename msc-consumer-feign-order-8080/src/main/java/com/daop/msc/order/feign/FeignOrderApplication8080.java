package com.daop.msc.order.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc
 * @Description:
 * @DATE: 2020-10-21
 * @AUTHOR: Administrator
 **/
@SpringBootApplication
@EnableFeignClients
public class FeignOrderApplication8080 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderApplication8080.class, args);
    }
}
