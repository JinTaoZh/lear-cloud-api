package com.zjt.cloud.global;

import org.springframework.stereotype.Component;

/**
 * @author zjt
 * @date 2020-09-10
 */
@Component
public class GlobalFallBack {


    public String fallBackMethod() {
        return "通用服务降级处理方法";
    }

}
