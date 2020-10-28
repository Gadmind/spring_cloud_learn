package com.daop.msc.seata.account.service.impl;

import com.daop.msc.seata.account.mapper.AccountMapper;
import com.daop.msc.seata.account.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.seata.order.service.impl
 * @Description:
 * @DATE: 2020-10-27
 * @AUTHOR: Administrator
 **/
@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Autowired
    private AccountMapper accountMapper;

    /**
     * 扣减账户余额
     *
     * @param userId 用户ID
     * @param money  账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------> account-service中扣减账户余额开始");
        //模拟异常，全局事务回滚
        //int age = 10 / 0;
        accountMapper.decrease(userId, money);
        log.info("------> account-service中扣减账户余额结束");
    }

}
