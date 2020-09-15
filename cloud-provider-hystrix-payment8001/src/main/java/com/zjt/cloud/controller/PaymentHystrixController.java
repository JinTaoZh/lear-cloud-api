package com.zjt.cloud.controller;

import com.zjt.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjt
 * @date 2020-09-08
 */
@Slf4j
@RestController
@RequestMapping("/payments-hystrix")
public class PaymentHystrixController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;


    @GetMapping("/{id}/ok")
    public String paymentInfoOk(@PathVariable Integer id) {
        String result = paymentService.paymentInfoOk(id);
        log.info(result + "  " + port);
        return result;
    }

    @GetMapping("/{id}/timeout")
    public String paymentTimeout(@PathVariable Integer id, Integer seconds) {
        String result = paymentService.paymentTimeout(id, seconds);
        log.info(result + "  " + port);
        return result;
    }

    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable Integer id) {
        log.info("id->" + id);
        String result = paymentService.paymentCircuitBreaker(id);
        log.info(result);
        return result;
    }


}
