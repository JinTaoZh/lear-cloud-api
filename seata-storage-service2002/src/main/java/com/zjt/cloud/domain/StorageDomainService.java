package com.zjt.cloud.domain;

import com.zjt.cloud.domain.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zjt
 * @date 2020-10-29
 */
@Service
public class StorageDomainService {

    @Autowired
    private StorageRepository repository;

    public Storage create(Storage storage) {
        return repository.save(storage);
    }

    public Storage findByCode(String commodityCode) {
        return repository.findByCommodityCode(commodityCode);
    }

    public void userBuy(String commodityCode, Integer count) {
        repository.userBuy(commodityCode, count);
    }


}
