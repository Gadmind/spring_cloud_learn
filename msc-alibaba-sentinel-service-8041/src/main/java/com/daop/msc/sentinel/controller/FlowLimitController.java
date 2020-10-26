package com.daop.msc.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.sentinel
 * @Description:
 * @DATE: 2020-10-26
 * @AUTHOR: Administrator
 **/
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/test-A")
    public String testA() {
        return "-------------test-A------------------";
    }

    @GetMapping("/test-B")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t....testB");
        return "-------------test-B------------------";
    }

    @GetMapping("/test-D")
    public String testD() {
        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");*/
        log.info("testD 测试异常比例");
        int age = 10 / 0;
        return "-------------test-D------------------";
    }

    @GetMapping("/test-E")
    public String testE() {
        log.info("testE 测试异常数");
        int age = 10 / 0;
        return "-------------test-E------------------";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "tesHotKey", blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        int age = 10 / 0;
        return "-------testHotKey-----------";
    }

    public String dealTestHotKey(String p1, String p2, BlockException e) {
        return "-------dealHotKey-----------";
    }


}
