package com.zjt.cloud.controller;

import cn.hutool.core.lang.UUID;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zjt.cloud.domain.CommonResult;
import com.zjt.cloud.domain.Payment;
import com.zjt.cloud.handler.MineBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjt
 * @date 2020-10-22
 */
@Slf4j
@RestController
@RequestMapping("/sentinel-limit")
public class SentinelLimitController {

    @GetMapping("/get-payment")
    @SentinelResource(value = "sentinel-limit-get-payment", blockHandler = "fusingGetPayment")
    public CommonResult<Payment> getPayment() {
        return new CommonResult<>(200, "Sentinel 限流测试成功", new Payment(10010L, UUID.fastUUID().toString()));
    }

    public CommonResult<Payment> fusingGetPayment(BlockException e) {
        log.info(e.getMessage());
        return new CommonResult<>(500, e.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("/custom")
    @SentinelResource(value = "custom-block-handler",
            blockHandlerClass = MineBlockHandler.class,
            blockHandler = "handlerBlockException",
            fallbackClass = MineBlockHandler.class,
            fallback = "handlerBlockException")
    public CommonResult<Payment> customBlockHandler(Integer id) {
        if (id == 5) {
            throw new ArithmeticException("id错误");
        }
        return new CommonResult<>(200, " success", new Payment(Long.valueOf(id), UUID.fastUUID().toString()));
    }

}
