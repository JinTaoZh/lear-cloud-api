package com.zjt.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author zjt
 * @date 2020-10-29
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CusOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userId;

    private String commodityCode;

    private Integer count;

    private Integer money;

    public CusOrder(String userId, String commodityCode, Integer count) {
        this.count = count;

        this.userId = userId;
        this.commodityCode = commodityCode;
    }

    /**
     * @param price 商品单价
     */
    void create(Integer price) {
        this.money = this.count * price;
    }

}
