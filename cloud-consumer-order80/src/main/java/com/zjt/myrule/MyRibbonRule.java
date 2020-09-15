package com.zjt.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zjt
 * @date 2020-09-05
 */
@Configuration
public class MyRibbonRule {

    @Bean
    public IRule MyRule() {
        //return new RandomRule();
        return new MyRule();
    }

}
