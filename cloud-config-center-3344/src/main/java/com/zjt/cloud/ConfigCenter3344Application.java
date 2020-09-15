package com.zjt.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.TimeZone;

/**
 * @author zjt
 * @date 2020-09-15
 */
@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
public class ConfigCenter3344Application {

    public static void main(String[] args) {
        // 时区设置
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(ConfigCenter3344Application.class, args);
    }

}
