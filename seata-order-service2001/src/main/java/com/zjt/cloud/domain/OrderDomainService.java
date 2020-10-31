package com.zjt.cloud.domain;

import com.zjt.cloud.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zjt
 * @date 2020-10-29
 */
@Service
public class OrderDomainService {

    @Autowired
    private OrderRepository repository;

    /**
     * @param cusOrder 订单基本信息
     * @param price 商品单价
     * @return
     */
    public CusOrder create(CusOrder cusOrder, Integer price) {
        cusOrder.create(price);
        return repository.save(cusOrder);
    }


}
