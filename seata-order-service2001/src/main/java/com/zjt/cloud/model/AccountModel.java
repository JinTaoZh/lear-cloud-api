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
public class AccountModel {

    private Integer id;

    private String userId;

    private Integer money; // 单位分

}
