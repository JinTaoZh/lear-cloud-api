package com.zjt.cloud.controller;

import com.zjt.cloud.domain.CommonResult;
import com.zjt.cloud.domain.Payment;
import com.zjt.cloud.domain.enums.CommonRestCode;
import com.zjt.cloud.rpcserve.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zjt
 * @date 2020-08-26
 */
@Slf4j
@RestController
@RequestMapping("/payments/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @Value("${server.port}")
    private String port;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping
    public CommonResult<Long> create(@RequestBody Payment payment) {
        long result = service.create(payment);
        if (result > 0) {
            return new CommonResult<>(CommonRestCode.SUCCESS, "操作成功，port：" + port, result);
        } else {
            return new CommonResult<>(CommonRestCode.BAD_REQUEST, null);
        }
    }

    @GetMapping("{id}")
    public CommonResult<Payment> findById(@PathVariable Long id) {
        Payment payment = service.findById(id);
        if (null != payment) {
            return new CommonResult<>(CommonRestCode.SUCCESS, "查询成功，port：" + port, payment);
        } else {
            return new CommonResult<>(CommonRestCode.BAD_REQUEST, String.format("查询失败id为->%d", id), null);
        }
    }

    @GetMapping("/discovery")
    public DiscoveryClient discovery() {
        // 获取注册进入Eureka 服务列表的信息
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instancesList = new ArrayList<>();
        services.forEach(item -> {
            log.info("*****element:" + item);
            // 根据微服务的具体名称获取 获取微服务的相关信息
            instancesList.addAll(discoveryClient.getInstances(item));
            instancesList.forEach(instances -> {
                // 微服务 serviceId
                String serviceId = instances.getServiceId();
                // 微服务 主机名
                String host = instances.getHost();
                // 微服务 端口号
                int port = instances.getPort();
                // 微服务 uri 地址
                URI uri = instances.getUri();
                log.info(serviceId + "\t" + host + "\t" + port + "\t" + uri);
            });
        });
        return this.discoveryClient;
    }

    @GetMapping("/time-out")
    public String paymentFeignTimeOut() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }

}
