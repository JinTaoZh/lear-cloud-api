package com.zjt.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zjt.cloud.domain.CommonResult;
import com.zjt.cloud.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zjt
 * @date 2020-10-22
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    public static final String RPC_URL = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate template;

    // 无任何配置
    @GetMapping("/payment/{id}")
    @SentinelResource(value = "consumer-payment")
    public CommonResult<Payment> findPayment(@PathVariable("id") Long id) {
        return this.getPayment(id);
    }

    @GetMapping("/only-fallback/{id}")
    @SentinelResource(value = "only-fallback", fallback = "paymentFallback") //fallback 仅处理业务异常
    public CommonResult<Payment> findPaymentOnlyFallback(@PathVariable("id") Long id) {
        return this.getPayment(id);
    }

    public CommonResult<Payment> paymentFallback(Long id, Throwable e) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(500, "业务异常->进入备用方法->异常内容:" + e.getMessage(), payment);
    }

    @GetMapping("/only-block/{id}")
    @SentinelResource(value = "only-block", blockHandler = "paymentBlock") // blockHandler仅处理配置异常
    public CommonResult<Payment> findPaymentOnlyBlock(@PathVariable("id") Long id) {
        return this.getPayment(id);
    }

    public CommonResult<Payment> paymentBlock(Long id, BlockException e) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(500, "sentinel 流控异常->进入备用方法->异常内容:" + e.getMessage(), payment);
    }


    // 配置处理配置异常 与 仅处理业务异常 配置异常的优先级高于 业务异常
    // 忽略异常 IllegalArgumentException
    @GetMapping("/payment-a/{id}")
    @SentinelResource(value = "consumer-payment-a", blockHandler = "paymentBlock", fallback = "paymentFallback",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> findPaymentA(@PathVariable("id") Long id) {
        return this.getPayment(id);
    }

    private CommonResult<Payment> getPayment(Long id) {
        CommonResult<Payment> result = template.getForObject(RPC_URL + "/payment/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("非法参数");
        } else if (result != null && result.getResult() == null) {
            throw new NullPointerException("空指针异常，未找到对应记录");
        }
        return result;
    }


}
