package com.zjt.cloud.service.rpc;

import com.zjt.cloud.model.StorageModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zjt
 * @date 2020-10-30
 */
@FeignClient(value = "seata-storage-service")
public interface StorageRPCService {

    @GetMapping("/storage/code")
    StorageModel findByCode(@RequestParam("commodityCode")String commodityCode);

    @PutMapping("/storage/buy")
    Integer userBuy(@RequestParam("commodityCode")String commodityCode, @RequestParam("count")Integer count);

}
