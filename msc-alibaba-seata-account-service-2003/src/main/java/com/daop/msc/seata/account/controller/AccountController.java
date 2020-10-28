package com.daop.msc.seata.account.controller;

import com.daop.msc.entities.CommonResult;
import com.daop.msc.seata.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.seata.order.controller
 * @Description:
 * @DATE: 2020-10-27
 * @AUTHOR: Administrator
 **/
@RestController
public class AccountController {

    private static final String ACCOUNT_URL_PREFIX = "/account";

    @Autowired
    private AccountService accountService;

    /**
     * 扣减账户余额
     *
     * @param userId 用户ID
     * @param money  金钱
     * @return
     */
    @PostMapping(ACCOUNT_URL_PREFIX + "/decrease")
    public CommonResult creatOrder(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult(200, "库存扣减成功");
    }
}
