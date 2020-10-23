package com.zjt.cloud.controller;

import com.zjt.cloud.domain.CommonResult;
import com.zjt.cloud.domain.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author zjt
 * @date 2020-10-22
 */
@RestController
@RequestMapping("/payment")
public class PaymentProviderController {

    public static HashMap<Long, Payment> map = new LinkedHashMap<Long, Payment>() {{
        put(1L, new Payment(1L, "value1"));
        put(2L, new Payment(2L, "value2"));
        put(3L, new Payment(3L, "value3"));
    }};

    @Value("${server.port}")
    private String port;

    @GetMapping("/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id) {
        if (id == 4) {
            throw new IllegalArgumentException("参数异常");
        }
        Payment payment = map.get(id);
        return new CommonResult<>(200, "success from port" + port, payment);
    }

}
