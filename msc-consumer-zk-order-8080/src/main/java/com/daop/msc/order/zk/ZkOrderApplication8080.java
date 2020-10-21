package com.daop.msc.order.zk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.zk
 * @Description: Zookeeper消费者启动类
 * @DATE: 2020-10-21
 * @AUTHOR: Administrator
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ZkOrderApplication8080 {
    public static void main(String[] args) {
        SpringApplication.run(ZkOrderApplication8080.class, args);
    }
}
