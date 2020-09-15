package com.zjt.cloud.controller;

import com.zjt.cloud.domain.CommonResult;
import com.zjt.cloud.domain.Payment;
import com.zjt.cloud.domain.enums.CommonRestCode;
import com.zjt.cloud.rpcserve.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author zjt
 * @date 2020-08-26
 */
@RestController
@RequestMapping("/payments/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @Value("${server.port}")
    private String port;


    @PostMapping
    public CommonResult<Long> create(@RequestBody Payment payment) {
        long result = service.create(payment);
        if (result > 0) {
            return new CommonResult<>(CommonRestCode.SUCCESS, "操作成功，port：" + port, result);
        } else {
            return new CommonResult<>(CommonRestCode.BAD_REQUEST, null);
        }
    }

    @GetMapping("{id}")
    public CommonResult<Payment> findById(@PathVariable Long id) {
        Payment payment = service.findById(id);
        if (null != payment) {
            return new CommonResult<>(CommonRestCode.SUCCESS, "查询成功，port：" + port, payment);
        } else {
            return new CommonResult<>(CommonRestCode.BAD_REQUEST, String.format("查询失败id为->%d", id), null);
        }
    }

}
