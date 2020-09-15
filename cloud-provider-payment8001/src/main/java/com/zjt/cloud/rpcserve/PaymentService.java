package com.zjt.cloud.rpcserve;

import com.zjt.cloud.domain.Payment;

/**
 * @author zjt
 * @date 2020-08-26
 */
public interface PaymentService {

    long create(Payment payment);

    Payment findById(Long id);

}
