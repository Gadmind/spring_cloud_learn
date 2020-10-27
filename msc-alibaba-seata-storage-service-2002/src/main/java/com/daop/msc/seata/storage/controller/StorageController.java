package com.daop.msc.seata.storage.controller;

import com.daop.msc.entities.CommonResult;
import com.daop.msc.entities.Order;
import com.daop.msc.seata.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.seata.order.controller
 * @Description:
 * @DATE: 2020-10-27
 * @AUTHOR: Administrator
 **/
@RestController
public class StorageController {

    private static final String STORAGE_URL_PREFIX = "/storage";

    @Autowired
    private StorageService storageService;

    /**
     * 扣减库存
     *
     * @param productId
     * @param count
     * @return
     */
    @GetMapping(STORAGE_URL_PREFIX + "/decrease")
    public CommonResult decreaseStorage(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "库存扣减成功");
    }
}
