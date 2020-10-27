package com.daop.msc.seata.account.service;

import com.daop.msc.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.seata.order.service
 * @Description:
 * @DATE: 2020-10-27
 * @AUTHOR: Administrator
 **/
public interface AccountService {
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
