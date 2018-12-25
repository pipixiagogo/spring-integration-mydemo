package com.lin.integrationjava.service.impl;

import com.lin.integrationjava.dto.Test;
import com.lin.integrationjava.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author lin
 */
@Service
public class SendServiceImpl implements SendService {

    @Autowired
    @Qualifier("testChannel")
    private MessageChannel testChannel;

    @Autowired
    @Qualifier("publishSubscribeChannel")
    private MessageChannel publishSubscribeChannel;

    @Autowired
    @Qualifier("publishSubscribe2Channel")
    private MessageChannel publishSubscribe2Channel;

    @Autowired
    @Qualifier("testRouteChannel")
    private MessageChannel testRouteChannel;

    /**
     * 测试传输dto
     */
    @Override
    public void testDto() {
        System.out.println("testDto方法");
        Test test = new Test();
        test.setName("testDtoDsl");
        test.setAge("18");
        testChannel.send(MessageBuilder.withPayload(test).build());
    }

    /**
     * 测试发布订阅
     */
    @Override
    public void testPublishSubscribeChannel(){
        System.out.println("testPublishSubscribeChannel方法");
        Test test = new Test();
        test.setName("testPSDsl");
        test.setAge("18");
        publishSubscribeChannel.send(MessageBuilder.withPayload(test).build());
        Test test2 = new Test();
        test2.setName("testPS2Dsl");
        test2.setAge("18");
        publishSubscribe2Channel.send(MessageBuilder.withPayload(test2).build());
    }

    @Override
    public void testRouteChannel() {
        System.out.println("testRouteChannel方法");
        Test test = new Test();
        test.setName("testRoute1");
        test.setAge("17");
        testRouteChannel.send(MessageBuilder.withPayload(test).build());
        Test test2 = new Test();
        test2.setName("testRoute2");
        test2.setAge("18");
        testRouteChannel.send(MessageBuilder.withPayload(test2).build());
    }

}
