package com.zjt.cloud.service.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zjt
 * @date 2020-10-30
 */
@FeignClient(value = "seata-account-service")
public interface AccountRPCService {

    @PutMapping("/account/consume")
    void consume(@RequestParam("userId") String userId, @RequestParam("money") Integer money);

}
