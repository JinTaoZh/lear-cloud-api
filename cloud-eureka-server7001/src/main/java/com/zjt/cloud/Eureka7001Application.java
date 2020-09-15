package com.zjt.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.TimeZone;

/**
 * @author zjt
 * @date 2020-08-27
 */
@SpringBootApplication
@EnableEurekaServer // 代表是服务中心
public class Eureka7001Application {

    public static void main(String[] args) {

        // 时区设置
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));

        SpringApplication.run(Eureka7001Application.class, args);
    }

}
