package com.lin.integration.service.impl;

import com.lin.integration.service.MqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MqServiceImpl implements MqService {

    @Autowired
    private MessageChannel mqTopicChannel;

    /**
     * 使用mq进行传输发送方法
     */
    @Override
    public void send() {
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","MqService");
        map.put("age","18");
        mqTopicChannel.send(MessageBuilder.withPayload(map).build());
    }
}
