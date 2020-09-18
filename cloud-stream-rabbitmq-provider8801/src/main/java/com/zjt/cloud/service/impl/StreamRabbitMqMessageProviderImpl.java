package com.zjt.cloud.service.impl;

import com.zjt.cloud.service.StreamRabbitMqMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @author zjt
 * @date 2020-09-17
 * EnableBinding(Source.class)
 * 通道channel 和 exchange 绑定在一起 Source 表示消息发送者 定义消息推送管道
 * {@link org.springframework.cloud.stream.messaging.Source}
 */
@Slf4j
@EnableBinding(Source.class) //定义消息推送管道
public class StreamRabbitMqMessageProviderImpl implements StreamRabbitMqMessageProvider {

    @Autowired
    private Source source;//注入接口和注入MessageChannel的区别在于发送时需不需要调用接口内的方法

//    @Resource
//    private MessageChannel output; // 消息发送管道

    @Override
    // 发送消息
    public String send() {
        String uuid = UUID.randomUUID().toString();
        source.output().send(MessageBuilder.withPayload(uuid).build());
        //假设注入了MessageChannel messageChannel; 因为绑定的是Source这个接口，
        //所以会使用其中的唯一产生MessageChannel的方法，那么下边的代码会是
        //output.send(MessageBuilder.withPayload(uuid).build());
        log.info("UUID->" + uuid);
        return uuid;
    }

}
