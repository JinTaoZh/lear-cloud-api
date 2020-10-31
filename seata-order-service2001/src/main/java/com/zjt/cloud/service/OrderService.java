package com.zjt.cloud.service;

import com.zjt.cloud.domain.CusOrder;
import com.zjt.cloud.domain.OrderDomainService;
import com.zjt.cloud.model.StorageModel;
import com.zjt.cloud.service.rpc.AccountRPCService;
import com.zjt.cloud.service.rpc.StorageRPCService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zjt
 * @date 2020-10-30
 */
@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderDomainService orderDomainService;

    @Autowired
    private StorageRPCService storageRPCService;

    @Autowired
    private AccountRPCService accountRPCService;


    /**
     * @param userId        用户id
     * @param commodityCode 商品编号
     * @param count         购买数量
     * @return 订单
     */
    @GlobalTransactional(name = "create_order", rollbackFor = Exception.class)
    //@Transactional
    public CusOrder createOrder(String userId, String commodityCode, Integer count) {
        StorageModel storageModel = storageRPCService.findByCode(commodityCode);
        Integer price = storageModel.getPrice();

        // 创建订单
        CusOrder cusOrder = new CusOrder(userId, commodityCode, count);
        log.info("-----> 开始创建订单");
        orderDomainService.create(cusOrder, price);
        // 扣减库存
        log.info("-----> 开始扣减库存");
        storageRPCService.userBuy(commodityCode, count);
        // 扣减账户余额
        Integer money = cusOrder.getMoney();
        log.info("-----> 开始扣减扣减账户余额");
        accountRPCService.consume(userId, money);
        return cusOrder;
    }


}
