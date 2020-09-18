package com.zjt.cloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @author zjt
 * @date 2020-09-18
 */
@Slf4j
@EnableBinding(Sink.class) // 消息接收
public class ReceiverMessageService {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT) // 作为输入源 消息监听
    public void input(Message<String> message) {
        String payload = message.getPayload();
        log.info("消费者\t" + port + "\t接收到信息----->" + payload);
    }

}
