package com.zjt.cloud.rpc;

import com.zjt.cloud.domain.CommonResult;
import com.zjt.cloud.domain.Payment;
import org.springframework.stereotype.Component;

/**
 * @author zjt
 * @date 2020-10-22
 */
@Component
public class PaymentRPCFallbackServer implements PaymentRPCServer{

    @Override
    public CommonResult<Payment> getPayment(Long id) {
        return new CommonResult<>(4444, "服务降级", new Payment(id, "errorSerial"));
    }
}
