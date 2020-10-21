package com.daop.msc.order.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.ribbonrule
 * @Description:
 * @DATE: 2020-10-21
 * @AUTHOR: Administrator
 **/
@Component
public class MyLB implements LoadBalance {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : (current + 1);
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("*****第几次访问next: " + next);
        return next;
    }
}
