package com.zjt.cloud.rpcserver;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zjt
 * @date 2020-09-25
 */
@FeignClient("nacos-payment-provider")
public interface PaymentNacosRpcServer {

    @GetMapping("/nacos-provider/{id}")
    String getPayment(@PathVariable("id") Integer id);

}
