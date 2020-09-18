package com.zjt.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.TimeZone;

/**
 * @author zjt
 * @date 2020-09-17
 */
@EnableEurekaClient
@SpringBootApplication
public class StreamProvider8801Application {

    public static void main(String[] args) {
        // 时区设置
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(StreamProvider8801Application.class, args);
    }

}
