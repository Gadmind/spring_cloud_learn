package com.daop.msc.sentinel;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.sentinel
 * @Description:
 * @DATE: 2020-10-26
 * @AUTHOR: Administrator
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelApplication8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication8401.class, args);
    }
}
