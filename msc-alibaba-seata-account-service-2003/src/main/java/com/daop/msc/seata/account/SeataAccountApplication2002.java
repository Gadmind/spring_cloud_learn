package com.daop.msc.seata.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.seata.order
 * @Description:
 * @DATE: 2020-10-27
 * @AUTHOR: Administrator
 **/
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动装配
public class SeataAccountApplication2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountApplication2002.class, args);
    }
}
