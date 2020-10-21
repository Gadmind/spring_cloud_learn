package com.daop.msc.order;

import com.daop.msc.ribbonrule.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.order
 * @Description: 启动类
 * @DATE: 2020-10-20
 * @AUTHOR: Administrator
 **/
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MSC-PAYMENT-SERVICE",configuration = MyRibbonRule.class)
public class EurekaOrderApplication8080 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaOrderApplication8080.class, args);
    }
}
