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
public class ConsulPayment8006Application {

    public static void main(String[] args) {
        // 时区设置
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));

        SpringApplication.run(ConsulPayment8006Application.class, args);
    }

}
