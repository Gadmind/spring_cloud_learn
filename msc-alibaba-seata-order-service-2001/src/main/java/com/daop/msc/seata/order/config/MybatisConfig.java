package com.daop.msc.seata.order.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.seata.order.config
 * @Description:
 * @DATE: 2020-10-27
 * @AUTHOR: Administrator
 **/
@Configuration
@MapperScan({"com.daop.msc.seata.order.mapper"})
public class MybatisConfig {
}
