package com.lin.integration.service.impl;

import com.lin.integration.dto.Test;
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
public class RouterSendServiceImpl implements com.lin.integration.service.RouterSendService {

    @Autowired
    @Qualifier("routingChannel")
    private MessageChannel routingChannel;

    @Autowired
    @Qualifier("routingTypeChannel")
    private MessageChannel routingTypeChannel;

    @Override
    public void routerA(String name, String age) {
        Test test = new Test();
        test.setAge(age);
        test.setName(name);
        routingChannel.send(MessageBuilder.withPayload(test).setHeader("testHeader", "A").build());
    }

    @Override
    public void routerB(String name, String age) {
        HashMap<String,String> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);
        routingChannel.send(MessageBuilder.withPayload(map).setHeader("testHeader", "B").build());
    }

    @Override
    public void routerString() {
        String str = "lin";
        routingTypeChannel.send(MessageBuilder.withPayload(str).build());
    }

    @Override
    public void routerInteger() {
        Integer a = 18;
        routingTypeChannel.send(MessageBuilder.withPayload(a).build());
    }
}
