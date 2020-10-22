package com.daop.msc.hystrix.payment;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @BelongsProject: springboot-cloud
 * @BelongsPackage: com.daop.msc.hystrix.payment
 * @Description: 启动类
 * @DATE: 2020-10-21 21:28
 * @AUTHOR: Daop
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HystrixApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication8001.class, args);
    }

    /**
     * 此配置是为了服务监控而配置，因为SpringCloud升级后
     * ServletRegistrationBean中的springboot默认路径不是“/hystrix.stream”
     * 只要在项目配置下面的Servlet就可以了
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
