package com.zjt.cloud.service;

import com.zjt.cloud.domain.Storage;
import com.zjt.cloud.domain.StorageDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zjt
 * @date 2020-10-30
 */
@Service
public class StorageService {

    @Autowired
    private StorageDomainService domainService;

    @Transactional
    public Storage create(Storage storage) {
        return domainService.create(storage);
    }

    public Storage findByCode(String commodityCode) {
        return domainService.findByCode(commodityCode);
    }

    @Transactional
    public void userBuy(String commodityCode, Integer count) {
        domainService.userBuy(commodityCode, count);
    }

}
