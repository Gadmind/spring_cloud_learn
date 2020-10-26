package com.daop.msc.nacos.provider.controller;

import com.daop.msc.entities.CommonResult;
import com.daop.msc.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @BelongsProject: spring_cloud_learn
 * @BelongsPackage: com.daop.msc.nacos.provider.controller
 * @Description:
 * @DATE: 2020-10-26
 * @AUTHOR: Administrator
 **/
@RestController
@RequestMapping("/nacos")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>(8);

    static {
        hashMap.put(1L, new Payment(1L, "bHfWLWbJLwVsrbE05ucjkogy48oPSmce"));
        hashMap.put(2L, new Payment(2L, "xP634pYOT5i1Qj3XfQeqoopCsJytA1wn"));
        hashMap.put(3L, new Payment(3L, "AuPl15qrpexgIZElFnAEsakZfvVjQvYN"));
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from mysql,serverPort: " + serverPort, payment);
        return result;
    }
}
