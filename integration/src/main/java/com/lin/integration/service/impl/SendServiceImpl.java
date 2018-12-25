package com.lin.integration.service.impl;

import com.lin.integration.dto.Test;
import com.lin.integration.service.interfaces.UseGetWaySender;
import com.lin.integration.service.interfaces.MoreParamSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author lin
 */
@Service
public class SendServiceImpl implements com.lin.integration.service.SendService {

    @Autowired
    @Qualifier("testChannel")
    private MessageChannel testChannel;

    @Autowired
    @Qualifier("moreParamChannel")
    private MessageChannel helloWorldMoreParamChannel;

    @Autowired
    private UseGetWaySender useGetWaySender;

    @Autowired
    private MoreParamSender moreParamSender;

    @Autowired
    @Qualifier("testInterceptorChannel")
    private MessageChannel testInterceptorChannel;

    @Autowired
    @Qualifier("bridgeSendChannel")
    private MessageChannel bridgeSendChannel;

    @Autowired
    @Qualifier("filterAChannel")
    private MessageChannel filterAChannel;

    @Autowired
    @Qualifier("transformerInChannel")
    private MessageChannel transformerInChannel;

    /**
     * 测试传输dto
     */
    @Override
    public void testDto() {
        System.out.println("testDto方法");
        Test test = new Test();
        test.setName("testDto");
        test.setAge("18");
        testChannel.send(MessageBuilder.withPayload(test).build());
    }

    /**
     * 测试多参数传输
     */
    @Override
    public void moreParamm() {
        System.out.println("greetMoreParam方法");
        HashMap<String, String> map = new HashMap();
        map.put("name", "moreParam");
        map.put("age", "18");
        helloWorldMoreParamChannel.send(MessageBuilder.withPayload(map).build());
    }

    /**
     * 测试网关dto
     */
    @Override
    public void getWay() {
        Test test = new Test();
        test.setAge("18");
        test.setName("getWay");
        useGetWaySender.sendMessage(test);
    }

    /**
     * 测试网关多参数
     */
    @Override
    public void getWayMoreParam() {
        HashMap<String, String> map = new HashMap();
        map.put("name", "getWayMoreParam");
        map.put("age", "18");
        moreParamSender.sendMessage(map);
    }

    /**
     * 测试拦截器
     */
    @Override
    public void testInterceptor() {
        Test test = new Test();
        test.setName("testInterceptor");
        test.setAge("18");
        testInterceptorChannel.send(MessageBuilder.withPayload(test).build());
    }

    @Override
    public void bridgeSend() {
        HashMap<String, String> map = new HashMap();
        map.put("name", "bridgeSend");
        map.put("age", "18");
        bridgeSendChannel.send(MessageBuilder.withPayload(map).build());
    }

    @Override
    public void filterSend (String name){
        HashMap<String, String> map = new HashMap();
        map.put("name", name);
        map.put("age", "18");
        filterAChannel.send(MessageBuilder.withPayload(map).build());
    }

    @Override
    public void transformerSend(String name){
        HashMap<String, String> map = new HashMap();
        map.put("name", name);
        transformerInChannel.send(MessageBuilder.withPayload(map).build());
    }

}
