package com.daop.msc.order.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.ribbonrule
 * @Description:
 * @DATE: 2020-10-21
 * @AUTHOR: Administrator
 **/
public interface LoadBalance {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
