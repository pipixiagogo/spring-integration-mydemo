package com.lin.integration.service.impl;

import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author lin
 */
@Service
public class MessageListenerImpl {

    public void processMessage(HashMap<String,Object> map) {
        System.out.println("MessageListener::::::Received message: " + map.toString());
    }
}
