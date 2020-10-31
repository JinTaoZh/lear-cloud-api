package com.zjt.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zjt.cloud.domain.CommonResult;
import com.zjt.cloud.domain.Payment;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zjt
 * @date 2020-10-22
 */
@Slf4j
public class MineBlockHandler {

    public static CommonResult<Payment> handlerBlockException(BlockException e) {
        return new CommonResult<>(500, "自定义限流处理");
    }

    public static CommonResult<Payment> handlerBlockException(Integer id, BlockException e) {
        log.info("id->" + id);
        log.info(e.getMessage());
        return new CommonResult<>(500, "自定义限流处理->id" + id);
    }
}
