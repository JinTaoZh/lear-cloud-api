package com.zjt.cloud.controllor;

import com.zjt.cloud.domain.CommonResult;
import com.zjt.cloud.domain.Payment;
import com.zjt.cloud.domain.enums.CommonRestCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zjt
 * @date 2020-08-26
 */
@Slf4j
@RestController
@RequestMapping("/consumer/payment")
public class ConsumeController {

    // 先固定写死跑通
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate template;

    @GetMapping
    public CommonResult<Payment> create(Payment payment) {
        return template.postForObject(PAYMENT_URL + "/payments/payment", payment, CommonResult.class);
    }

    @GetMapping("/entity")
    public CommonResult<Payment> createR(Payment payment) {
        ResponseEntity<CommonResult> entity = template.postForEntity(PAYMENT_URL + "/payments/payment", payment, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }
        return new CommonResult(CommonRestCode.BAD_REQUEST, null);
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> findById(@PathVariable Long id) {
        String url = PAYMENT_URL + "/payments/payment/" + id;
        log.info(url);
        return template.getForObject(url, CommonResult.class);
    }

    @GetMapping("/{id}/entity")
    public CommonResult getForEntity(@PathVariable Long id) {
        String url = PAYMENT_URL + "/payments/payment/" + id;
        log.info(url);
        ResponseEntity<CommonResult> entity = template.getForEntity(url, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }
        return new CommonResult(CommonRestCode.BAD_REQUEST, null);
    }


}
