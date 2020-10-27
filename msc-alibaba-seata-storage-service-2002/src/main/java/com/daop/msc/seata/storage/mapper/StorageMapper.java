package com.daop.msc.seata.storage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.seata.order.mapper
 * @Description:
 * @DATE: 2020-10-27
 * @AUTHOR: Administrator
 **/
@Mapper
public interface StorageMapper {
    void decrease(@Param("produceId") Long produceId, @Param("count") Integer count);
}
