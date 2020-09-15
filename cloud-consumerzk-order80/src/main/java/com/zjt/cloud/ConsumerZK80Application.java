package com.zjt.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.TimeZone;

/**
 * @author zjt
 * @date 2020-08-28
 */
@SpringBootApplication
@EnableDiscoveryClient // 该注解用于向使用consul 或者zookeeper 作为注册中心是注册服务
public class ConsumerZK80Application {

    public static void main(String[] args) {
        // 时区设置
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));

        SpringApplication.run(ConsumerZK80Application.class, args);

    }

}
