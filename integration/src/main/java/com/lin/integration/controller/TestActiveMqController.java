package com.lin.integration.controller;

import com.lin.integration.service.MqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 测试mq的controller
 *
 * @author lin
 */
@RestController
@RequestMapping("/mqTest")
public class TestActiveMqController {

    @Autowired
    private MqService mqService;

    /**
     * 测试方法
     * <p>
     * 接收类 {@link com.lin.integration.service.impl.MessageListenerImpl#processMessage(HashMap)}
     */
    @GetMapping("/postMessage")
    public void postMessage() {
        System.out.println("postMessage方法");
        mqService.send();
    }

}
