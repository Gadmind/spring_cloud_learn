package com.daop.msc.gateway.config;

import org.apache.http.protocol.HTTP;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.gateway.config
 * @Description: 通过代码方式实现网关路由
 * @DATE: 2020-10-22
 * @AUTHOR: Administrator
 **/
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("pathRoute", r ->
                r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        routes.route("pathRoute", r ->
                r.path("/guoji")
                        .uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
