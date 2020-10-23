package com.zjt.cloud.rpc;

import com.zjt.cloud.domain.CommonResult;
import com.zjt.cloud.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zjt
 * @date 2020-10-22
 */
@Component
@FeignClient(value = "nacos-payment-provider", fallback = PaymentRPCFallbackServer.class)
public interface PaymentRPCServer {

    @GetMapping("/payment/{id}")
    CommonResult<Payment> getPayment(@PathVariable(value = "id") Long id);

}
