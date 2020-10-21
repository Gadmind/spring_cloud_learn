package com.daop.msc.hystrix.payment.controller;

import com.daop.msc.hystrix.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: springboot-cloud
 * @BelongsPackage: com.daop.msc.hystrix.payment.controller
 * @Description:
 * @DATE: 2020-10-21 21:39
 * @AUTHOR: Daop
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoOk(id);
        log.info("*****result: " + result);
        return result;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        String result = paymentService.paymentTimeout(id);
        log.info("*****result: " + result);
        return result;
    }

    //    ++++++服务熔断
    @GetMapping("/circuit/{id}")
    public String paymentCircuit(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("====result"+result);
        return result;
    }
}
