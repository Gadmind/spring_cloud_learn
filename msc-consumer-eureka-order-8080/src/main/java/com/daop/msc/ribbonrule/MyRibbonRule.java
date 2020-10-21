package com.daop.msc.ribbonrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.order.com.daop.msc
 * @Description: 替换默认负载均衡配置
 * @DATE: 2020-10-21
 * @AUTHOR: Administrator
 **/
@Configuration
public class MyRibbonRule {
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
