package com.zjt.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import java.util.TimeZone;

/**
 * @author zjt
 * @date 2020-09-11
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboard9001Application {

    public static void main(String[] args) {
        // 时区设置
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(HystrixDashboard9001Application.class, args);
    }

}
