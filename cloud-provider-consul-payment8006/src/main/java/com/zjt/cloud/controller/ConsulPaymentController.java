package com.zjt.cloud.controller;

import cn.hutool.core.lang.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjt
 * @date 2020-08-31
 */
@Slf4j
@RestController
@RequestMapping("/consul-payment")
public class ConsulPaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping
    public String getPaymentConsul() {
        return "cloud with consul:" + port + "\t" + UUID.fastUUID().toString();
    }

}
