package com.zjt.cloud.domain;

import com.zjt.cloud.domain.repository.AccountRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zjt
 * @date 2020-10-26
 */
@Service
public class AccountDomainService {

    @Autowired
    private AccountRepository repository;


    public Account create(Account account) {
        return repository.save(account);
    }

    public void consume(String userId, Integer money) {
        if (StringUtils.isBlank(userId)) {
            throw new IllegalArgumentException("用户未登录");
        }
        if (userId.equals("5")) {
            throw new IllegalArgumentException("用户已被例如失信人员");
        }
        repository.userConsume(userId, money);
    }

}
