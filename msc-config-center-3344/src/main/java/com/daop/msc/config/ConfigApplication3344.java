package com.daop.msc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.config
 * @Description:
 * @DATE: 2020-10-22
 * @AUTHOR: Administrator
 **/
@SpringBootApplication
@EnableConfigServer
public class ConfigApplication3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication3344.class, args);
    }
}
