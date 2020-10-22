package com.daop.msc.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.hystrix.dashboard
 * @Description: Hystrix仪表盘启动类
 * @DATE: 2020-10-22
 * @AUTHOR: Administrator
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication9001.class, args);
    }
}
