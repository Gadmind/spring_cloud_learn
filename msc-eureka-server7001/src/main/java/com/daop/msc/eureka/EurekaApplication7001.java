package com.daop.msc.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @BelongsProject: springboot-cloud
 * @BelongsPackage: com.daop.msc.eureka
 * @Description: Eureka服务启动类
 * @DATE: 2020-10-20 20:43
 * @AUTHOR: Daop
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication7001.class, args);
    }
}
