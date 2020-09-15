package com.zjt.cloud.rpcserve.impl;

import com.zjt.cloud.dao.PaymentDao;
import com.zjt.cloud.domain.Payment;
import com.zjt.cloud.rpcserve.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zjt
 * @date 2020-08-26
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao dao;


    @Override
    public long create(Payment payment) {
        return dao.create(payment);
    }

    @Override
    public Payment findById(Long id) {
        return dao.findById(id);
    }
}
