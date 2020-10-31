package com.zjt.cloud.controller;

import com.zjt.cloud.domain.CommonResult;
import com.zjt.cloud.domain.Payment;
import com.zjt.cloud.rpc.PaymentRPCServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjt
 * @date 2020-10-22
 */
@RestController
@RequestMapping("/consumer/feign")
public class ConsumerFeignController {

    @Autowired
    private PaymentRPCServer paymentRPCServer;

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable(value = "id") Long id) {
        return paymentRPCServer.getPayment(id);
    }

}
