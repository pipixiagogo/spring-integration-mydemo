package com.lin.integrationjava.controller;

import com.lin.integrationjava.service.MqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 测试mq的controller
 *
 * @author lin
 */
@RestController
@RequestMapping("/mqTest")
public class TestActiveMqController {

//    @Autowired
//    private MqService mqService;

    /**
     * 测试方法
     * <p>
     * 接收类 {@link com.lin.integrationjava.service.impl.MessageListenerImpl#processMessage(HashMap)}
     */
//    @GetMapping("/postMessage")
//    public void postMessage() {
//        System.out.println("postMessage方法");
//        mqService.send();
//    }

}
