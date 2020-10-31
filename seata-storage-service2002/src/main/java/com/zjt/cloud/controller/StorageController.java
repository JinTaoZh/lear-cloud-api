package com.zjt.cloud.controller;

import com.zjt.cloud.domain.Storage;
import com.zjt.cloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zjt
 * @date 2020-10-30
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping
    public Storage create(Storage storage) {
        return storageService.create(storage);
    }

    @GetMapping("/code")
    public Storage findByCode(String commodityCode) {
        return storageService.findByCode(commodityCode);
    }

    @PutMapping("/buy")
    public void userBuy(String commodityCode,Integer count) {
        storageService.userBuy(commodityCode, count);
    }

}
