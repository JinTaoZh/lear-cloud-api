package com.zjt.cloud.controller;

import com.zjt.cloud.domain.Account;
import com.zjt.cloud.sevice.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjt
 * @date 2020-10-26
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account create(Account account) {
        return accountService.create(account);
    }

    @PutMapping("/consume")
    public void consume(String userId, Integer money) {
        accountService.consume(userId, money);
    }

}
