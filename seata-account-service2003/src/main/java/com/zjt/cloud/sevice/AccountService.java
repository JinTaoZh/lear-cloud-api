package com.zjt.cloud.sevice;

import com.zjt.cloud.domain.Account;
import com.zjt.cloud.domain.AccountDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zjt
 * @date 2020-10-26
 */
@Slf4j
@Service
public class AccountService {

    @Autowired
    private AccountDomainService domainService;

    @Transactional// 用户创建事务由自己负责提交或者回滚
    public Account create(Account account) {
        return domainService.create(account);
    }

    @Transactional
    public void consume(String userId, Integer money) {
        domainService.consume(userId, money);
    }

}
