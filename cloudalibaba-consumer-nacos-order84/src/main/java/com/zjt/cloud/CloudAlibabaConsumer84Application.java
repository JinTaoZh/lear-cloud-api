package com.zjt.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.TimeZone;

/**
 * @author zjt
 * @date 2020-10-22
 */
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaConsumer84Application {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(CloudAlibabaConsumer84Application.class, args);
    }
}
