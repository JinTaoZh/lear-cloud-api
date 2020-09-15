package com.zjt.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.TimeZone;

/**
 * @author zjt
 * @date 2020-08-26
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class Payment8001Application {

    public static void main(String[] args) {

        // 时区设置
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));

        SpringApplication.run(Payment8001Application.class, args);
    }

}
