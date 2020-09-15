package com.zjt.cloud.rpcserver;

import com.zjt.cloud.rpcserver.impl.PaymentRPCLocalCallImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zjt
 * @date 2020-09-09
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentRPCLocalCallImpl.class)
public interface PaymentRPCLocalCall {

    @GetMapping("/payments-hystrix/{id}/ok")
    String paymentInfoOk(@PathVariable(value = "id") Integer id);

    @GetMapping("/payments-hystrix/{id}/timeout")
    String paymentTimeout(@PathVariable(value = "id") Integer id, @RequestParam(value = "seconds") Integer seconds);

}
