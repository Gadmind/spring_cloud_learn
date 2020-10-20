package com.daop.msc.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @BelongsProject: springboot-cloud
 * @BelongsPackage: com.daop.msc.eureka
 * @Description:
 * @DATE: 2020-10-20 21:28
 * @AUTHOR: Daop
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication7002.class,args);
    }
}
