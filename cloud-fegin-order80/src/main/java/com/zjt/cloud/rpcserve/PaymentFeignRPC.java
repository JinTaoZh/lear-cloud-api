package com.zjt.cloud.rpcserve;

import com.zjt.cloud.domain.CommonResult;
import com.zjt.cloud.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zjt
 * @date 2020-09-07
 */
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignRPC {

    @GetMapping("/payments/payment/{id}")
    CommonResult<Payment> findById(@PathVariable(value = "id") Long id);

    @GetMapping("/payments/payment/time-out")
    String paymentTimeOut();

}
