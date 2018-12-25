package com.lin.integration.service.impl;

import com.lin.integration.dto.Test;
import com.lin.integration.service.PublishSubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class PublishSubscribeServiceImpl implements PublishSubscribeService {

    @Autowired
    @Qualifier("pubsubChannel")
    private PublishSubscribeChannel publishSubscribeChannel;

    @Override
    public void pubsubSend() {
        Test test = new Test();
        test.setName("pubsubSend");
        test.setAge("18");
        publishSubscribeChannel.send(MessageBuilder.withPayload(test).build());
    }

}
