package com.zjt.cloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author zjt
 * @date 2020-10-30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StorageModel {

    private Integer id;

    private String commodityCode;

    private Integer count; // 总数量

    private Integer price; // 单价

}
