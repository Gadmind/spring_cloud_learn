package com.daop.msc.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.config.client
 * @Description:
 * @DATE: 2020-10-22
 * @AUTHOR: Administrator
 **/
@RestController
@RefreshScope
public class ConfigController {
    @Value("${config.info}")
    public String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
