package com.zjt.cloud.rpcserver.impl;

import com.zjt.cloud.rpcserver.PaymentRPCLocalCall;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author zjt
 * @date 2020-09-10
 */
@Slf4j
@Component
public class PaymentRPCLocalCallImpl implements PaymentRPCLocalCall {


    @Override
    public String paymentInfoOk(Integer id) {
        String s = "PaymentRPCLocalCallImpl fall back paymentInfoOk";
        log.info(s);
        return s;
    }

    @Override
    public String paymentTimeout(Integer id, Integer seconds) {
        String s = "PaymentRPCLocalCallImpl fall back paymentTimeout";
        log.info(s);
        return s;
    }

}
