package com.lin.integration.controller;

import com.lin.integration.dto.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试http的调用
 *
 * @author lin
 * @date 2018-12-07
 */
@RestController
@RequestMapping("/testH")
public class TestHttpController {

    @Autowired
    @Qualifier("httpSendChannel")
    private MessageChannel httpSendChannel;

    /**
     * 调用接口使用
     */
    @GetMapping("/send")
    public void send(String str) {
        System.out.println("http_send");
        httpSendChannel.send(MessageBuilder.withPayload(str).build());
    }

    /**
     * http接受时候接口
     */
    @GetMapping("/receiver")
    public void receiver(String str) {
        System.out.println("http_receiver,接受参数为"+str);
    }
}
