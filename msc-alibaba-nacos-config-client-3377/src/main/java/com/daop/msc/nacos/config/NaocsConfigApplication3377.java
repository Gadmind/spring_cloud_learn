package com.daop.msc.nacos.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.nacos.config
 * @Description:
 * @DATE: 2020-10-26
 * @AUTHOR: Administrator
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class NaocsConfigApplication3377 {
    public static void main(String[] args) {
        SpringApplication.run(NaocsConfigApplication3377.class, args);
    }
}
