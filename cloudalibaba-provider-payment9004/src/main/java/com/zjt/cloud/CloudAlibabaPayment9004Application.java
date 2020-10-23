package com.zjt.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.TimeZone;

/**
 * @author zjt
 * @date 2020-10-22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaPayment9004Application {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(CloudAlibabaPayment9004Application.class, args);
    }
}
