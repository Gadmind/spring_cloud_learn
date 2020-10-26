package com.daop.msc.nacos.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.nacos.provider
 * @Description:
 * @DATE: 2020-10-26
 * @AUTHOR: Administrator
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class NacosApplication9003 {
    public static void main(String[] args) {
        SpringApplication.run(NacosApplication9003.class, args);
    }
}
