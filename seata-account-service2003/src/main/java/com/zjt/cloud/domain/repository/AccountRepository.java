package com.zjt.cloud.domain.repository;

import com.zjt.cloud.domain.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author zjt
 * @date 2020-10-26
 */
public interface AccountRepository extends PagingAndSortingRepository<Account, Integer> {

    Account findByUserId(String userId);

    @Modifying
    @Query(nativeQuery = true, value = "update `account` set money = money - ?2 where user_id = ?1")
    Integer userConsume(String userId, Integer money);

}
