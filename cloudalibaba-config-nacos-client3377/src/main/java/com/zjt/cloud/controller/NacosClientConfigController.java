package com.zjt.cloud.controller;

import com.zjt.cloud.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjt
 * @date 2020-09-25
 */
@RestController
@RequestMapping("/nacos-config")
public class NacosClientConfigController {


    @Autowired
    private Config config;


    @GetMapping("/info")
    public String getConfigInfo() {
        return config.getConfigInfo();
    }

}
