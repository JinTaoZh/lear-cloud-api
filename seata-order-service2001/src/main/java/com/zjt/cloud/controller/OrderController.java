package com.zjt.cloud.controller;

import com.zjt.cloud.domain.CusOrder;
import com.zjt.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjt
 * @date 2020-10-30
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public CusOrder create(String userId, String commodityCode, Integer count) {
        return orderService.createOrder(userId, commodityCode, count);
    }


}
