package com.zjt.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.TimeZone;

/**
 * @author zjt
 * @date 2020-08-31
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsul80Application {

    public static void main(String[] args) {
        // 时区设置
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));

        SpringApplication.run(ConsumerConsul80Application.class, args);
    }
}
