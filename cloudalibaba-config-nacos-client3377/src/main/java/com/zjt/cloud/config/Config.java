package com.zjt.cloud.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author zjt
 * @date 2020-09-25
 */
@Data
@Component
@RefreshScope // 动态刷新
public class Config {

    @Value("${config.info}")
    private String configInfo;

}
