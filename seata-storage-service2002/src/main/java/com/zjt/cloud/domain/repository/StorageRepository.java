package com.zjt.cloud.domain.repository;

import com.zjt.cloud.domain.Storage;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author zjt
 * @date 2020-10-29
 */
public interface StorageRepository extends PagingAndSortingRepository<Storage, Integer> {

    Storage findByCommodityCode(String commodityCode);

    @Modifying
    @Query(nativeQuery = true, value = "update `storage` set `count` = `count` - ?2 where commodity_code = ?1")
    Integer userBuy(String commodityCode, Integer count);

}
