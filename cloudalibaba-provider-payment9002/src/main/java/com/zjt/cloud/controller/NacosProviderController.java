package com.zjt.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjt
 * @date 2020-09-21
 */
@RestController
@RequestMapping("/nacos-provider")
public class NacosProviderController {

    @Value("${server.port}")
    public String port;

    @GetMapping("/{id}")
    public String getPayment(@PathVariable Integer id) {
        return "Nacos client port \t" + port + "\t id" + id;
    }

}
