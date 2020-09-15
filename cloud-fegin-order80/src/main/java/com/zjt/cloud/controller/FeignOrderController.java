package com.zjt.cloud.controller;

import com.zjt.cloud.domain.CommonResult;
import com.zjt.cloud.domain.Payment;
import com.zjt.cloud.rpcserve.PaymentFeignRPC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjt
 * @date 2020-09-07
 */
@RestController
@RequestMapping("/feign-order")
public class FeignOrderController {

    @Autowired
    private PaymentFeignRPC paymentFeignRPC;


    @GetMapping("/{id}")
    public CommonResult<Payment> findById(@PathVariable Long id) {
        return paymentFeignRPC.findById(id);
    }

    @GetMapping("/time-out")
    public String paymentTimeOut() {
        return paymentFeignRPC.paymentTimeOut();
    }
}
