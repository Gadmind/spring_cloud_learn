package com.daop.msc.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.order.config
 * @Description: 配置类
 * @DATE: 2020-10-20
 * @AUTHOR: Administrator
 **/
@Configuration
public class ApplicationContextConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
