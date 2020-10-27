package com.daop.msc.seata.account.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.seata.order.mapper
 * @Description:
 * @DATE: 2020-10-27
 * @AUTHOR: Administrator
 **/
@Mapper
public interface AccountMapper {
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
