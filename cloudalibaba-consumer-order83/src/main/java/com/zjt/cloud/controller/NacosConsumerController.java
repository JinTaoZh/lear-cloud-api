package com.zjt.cloud.controller;

import com.zjt.cloud.rpcserver.PaymentNacosRpcServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjt
 * @date 2020-09-25
 */
@RestController
@RequestMapping("/nacos-consumer")
public class NacosConsumerController {

    @Autowired
    private PaymentNacosRpcServer rpcServer;

    @GetMapping("/{id}")
    public String getPaymentInfo(@PathVariable Integer id) {
        return rpcServer.getPayment(id);
    }

}
