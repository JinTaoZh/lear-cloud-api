package com.zjt.cloud.domain;

import com.zjt.cloud.domain.enums.CommonRestCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zjt
 * @date 2020-08-26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    private int code;

    private String msg;

    private T result;

    public CommonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResult(CommonRestCode code, String msg, T result) {
        this.code = code.getCode();
        this.msg = StringUtils.isNotBlank(msg) ? msg : code.getValue();
        this.result = result;
    }

    public CommonResult(CommonRestCode code, T result) {
        this.code = code.getCode();
        this.msg = StringUtils.isNotBlank(msg) ? msg : code.getValue();
        this.result = result;
    }

}
