package com.daop.msc.seata.storage.service.impl;

import com.daop.msc.seata.storage.mapper.StorageMapper;
import com.daop.msc.seata.storage.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.seata.order.service.impl
 * @Description:
 * @DATE: 2020-10-27
 * @AUTHOR: Administrator
 **/
@Service
public class StorageServiceImpl implements StorageService {
    private static final Logger log = LoggerFactory.getLogger(StorageServiceImpl.class);
    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long produceId, Integer count) {
        log.info("------> storage-service中扣减库存开始");
        log.info("------> 商品ID：" + produceId + "\t 扣减数量：" + count);
        storageMapper.decrease(produceId, count);
        log.info("------> storage-service中扣减库存结束");
    }
}
