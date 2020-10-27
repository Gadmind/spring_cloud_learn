package com.daop.msc.seata.order.service;

import com.daop.msc.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.seata.order.service
 * @Description:
 * @DATE: 2020-10-27
 * @AUTHOR: Administrator
 **/
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("produceId") Long produceId, @RequestParam("count") Integer count);
}
