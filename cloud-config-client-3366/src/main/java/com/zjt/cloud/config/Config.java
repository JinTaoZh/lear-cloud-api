package com.zjt.cloud.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author zjt
 * @date 2020-09-16
 */
@Data
@Component
@RefreshScope
public class Config {

    @Value("${config.info}")
    private String configInfo;

    @Value("${config.name}")
    private String name;

}
