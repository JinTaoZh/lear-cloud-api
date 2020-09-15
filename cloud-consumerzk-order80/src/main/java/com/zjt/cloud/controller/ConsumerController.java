package com.zjt.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zjt
 * @date 2020-08-28
 */
@Slf4j
@RestController
@RequestMapping("/zookeeper/consumer")
public class ConsumerController {

    private static final String INVOKE_URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate template;


    @GetMapping
    public String getPaymentZK() {
        return template.getForObject(INVOKE_URL + "/zookeeper/payment", String.class);
    }


}
