package com.zjt.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zjt.cloud.rpcserver.PaymentRPCLocalCall;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjt
 * @date 2020-09-09
 */
@Slf4j
@RestController
@RequestMapping("/consumer-hystrix")
@DefaultProperties(defaultFallback = "fallBackMethod", commandProperties = {
        // 设置全局 响应超时时间
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
})
public class ConsumerHystrixController {

    @Autowired
    private PaymentRPCLocalCall paymentRPCLocalCall;

    @GetMapping("/{id}/ok")
    public String paymentInfoOk(@PathVariable(value = "id") Integer id) {
        return paymentRPCLocalCall.paymentInfoOk(id);
    }

    @GetMapping("/{id}/timeout")
//    @HystrixCommand(fallbackMethod = "paymentTimeoutFallBacks", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })
    @HystrixCommand
    public String paymentTimeout(@PathVariable(value = "id") Integer id, Integer seconds) {
        String s = paymentRPCLocalCall.paymentTimeout(id, seconds);
        log.info(s);
        return s;
    }

    private String paymentTimeoutFallBacks(Integer id, Integer seconds) {
        return "80端降级方法->线程池：" + Thread.currentThread().getName() + "，paymentTimeout->" + id;
    }

    private String fallBackMethod() {
        return "通用服务降级处理方法->controller";
    }

}
