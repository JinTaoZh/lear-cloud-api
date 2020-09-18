package com.zjt.cloud.comtroller;

import com.zjt.cloud.service.StreamRabbitMqMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjt
 * @date 2020-09-17
 */
@RestController
@RequestMapping("/stream")
public class StreamSendMessageController {

    @Autowired
    private StreamRabbitMqMessageProvider provider;

    @GetMapping("/send")
    public String sendMessage() {
        return provider.send();
    }

}
