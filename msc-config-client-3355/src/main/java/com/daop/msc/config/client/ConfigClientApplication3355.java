package com.daop.msc.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.config
 * @Description:
 * @DATE: 2020-10-22
 * @AUTHOR: Administrator
 **/
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientApplication3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication3355.class, args);
    }
}
