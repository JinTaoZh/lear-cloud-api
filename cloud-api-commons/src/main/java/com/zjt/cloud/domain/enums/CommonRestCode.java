package com.zjt.cloud.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zjt
 * @date 2020-08-26
 */
@Getter
@AllArgsConstructor
public enum CommonRestCode {

    SUCCESS(200, "请求成功"),

    BAD_REQUEST(400, "请求失败"),

    FAIL(500, "服务器出现异常");

    private final int code; // 操作编码

    private final String value; // 默认提示内容


}
