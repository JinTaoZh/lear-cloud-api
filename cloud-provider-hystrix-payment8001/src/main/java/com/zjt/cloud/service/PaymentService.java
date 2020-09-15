package com.zjt.cloud.service;

/**
 * @author zjt
 * @date 2020-09-08
 */
public interface PaymentService {

    String paymentInfoOk(Integer id);

    String paymentTimeout(Integer id, Integer seconds);

    String paymentCircuitBreaker(Integer id);

}
