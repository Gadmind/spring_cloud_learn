package com.daop.msc.order.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: springboot-cloud
 * @BelongsPackage: com.daop.msc.order.feign.config
 * @Description:
 * @DATE: 2020-10-21 20:40
 * @AUTHOR: Daop
 **/
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
