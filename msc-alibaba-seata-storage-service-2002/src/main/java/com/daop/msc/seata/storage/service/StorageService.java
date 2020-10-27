package com.daop.msc.seata.storage.service;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.seata.order.service
 * @Description:
 * @DATE: 2020-10-27
 * @AUTHOR: Administrator
 **/
public interface StorageService {
    void decrease(@RequestParam("produceId") Long produceId, @RequestParam("count") Integer count);
}
