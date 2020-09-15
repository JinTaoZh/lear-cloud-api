package com.zjt.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zjt.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zjt
 * @date 2020-09-08
 */
@Slf4j
@Service
@DefaultProperties(defaultFallback = "paymentCircuitBreakerFallBack", commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
        //用来设置在滚动时间窗中，断路器熔断的最小请求数。例如，默认该值为20的时候，如果滚动时间窗（默认10秒）内仅收到19个请求，
        // 即使这19个请求都失败了，断路器也不会打开
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
        // 用来设置当断路器打开之后的休眠时间窗。休眠时间窗结束之后，会将断路器设置为“半开”状态，尝试熔断的请求命令，
        // 如果依然时候就将断路器继续设置为“打开”状态，如果成功，就设置为“关闭”状态。
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
        // 用来设置断路器打开的错误百分比条件。默认值为50，表示在滚动时间窗中，在请求值超过requestVolumeThreshold阈值的前提下，
        // 如果错误请求数百分比超过50，就把断路器设置为“打开”状态，否则就设置为“关闭”状态。
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
        // 更加详细的配置和解释 参照com.netflix.hystrix.HystrixCommandProperties
})
public class PaymentServiceImpl implements PaymentService {

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public String paymentInfoOk(Integer id) {
        return "正常方法->线程池：" + Thread.currentThread().getName() + "，paymentInfoOk->" + id;
    }

    // 服务降级
    @Override
    @HystrixCommand(fallbackMethod = "paymentTimeoutFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
    })
    public String paymentTimeout(Integer id, Integer seconds) {
        //int i = 10 / 0;
        try {
            // 模拟长业务流程 线程睡眠 seconds 单位秒
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "超时方法->线程池：" + Thread.currentThread().getName() + "，paymentTimeout->" + id;
    }

    private String paymentTimeoutFallBack(Integer id, Integer seconds) {
        return "8001降级方法->线程池：" + Thread.currentThread().getName() + "，paymentTimeout->" + id;
    }

    // 服务熔断
    @Override
    @HystrixCommand
    public String paymentCircuitBreaker(Integer id) {
        if (id < 1) {
            throw new RuntimeException("id 必须大于0 \t id ->" + id);
        }
        return Thread.currentThread().getName() + "\t" + "UUID->" + IdUtil.fastSimpleUUID();
    }

    public String paymentCircuitBreakerFallBack() {
        return Thread.currentThread().getName() + "\t" + "id 必须大于0,请重新尝试";
    }

}
