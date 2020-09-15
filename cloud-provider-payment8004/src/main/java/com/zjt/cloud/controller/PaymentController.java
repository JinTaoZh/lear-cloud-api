package com.zjt.cloud.controller;

import cn.hutool.core.lang.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjt
 * @date 2020-08-28
 */
@Slf4j
@RestController
@RequestMapping("/zookeeper/payment")
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping
    public String getPaymentZK() {
        return "cloud with zookeeper:" + port + "\t" + UUID.fastUUID().toString();
    }

}
