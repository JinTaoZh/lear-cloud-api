package com.zjt.cloud.controller;

import com.zjt.cloud.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zjt
 * @date 2020-09-16
 */
@RestController
@RequestMapping("/config-client")
public class ConfigClientController {

    @Autowired
    private Config config;

    @GetMapping
    private Map<String, String> getConfigInfo() {
        return new LinkedHashMap<String, String>() {{
            put("info", config.getConfigInfo());
            put("name", config.getName());
        }};
    }

}
