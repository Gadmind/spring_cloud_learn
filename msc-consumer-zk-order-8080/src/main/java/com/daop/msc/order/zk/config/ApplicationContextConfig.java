package com.daop.msc.order.zk.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.zk.order.config
 * @Description: RestTemplate配置类
 * @DATE: 2020-10-21
 * @AUTHOR: Administrator
 **/
@Configuration
public class ApplicationContextConfig {
    /**
     * 返回远程调用bean@LoadBalanced开启服务负载均衡默认为轮询
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
