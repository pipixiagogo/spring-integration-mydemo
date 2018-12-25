package com.lin.integration.controller;

import com.lin.integration.service.RouterSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试channelController
 *
 * @author lin
 */
@RestController
@RequestMapping("/testRouter")
public class TestRouterChannleController {

    @Autowired
    private RouterSendService routerSendService;

    /**
     * 测试路由方法
     */
    @GetMapping("/testRouter")
    public String testRouter() {
        System.out.println("testRouter");
        this.routerSendService.routerA("RouterA", "18");
        this.routerSendService.routerB("RouterB", "18");
        return "hehe";
    }

    /**
     * 根据参数类型判断通道
     */
    @GetMapping("/testRouterByType")
    public String testRouterByType() {
        System.out.println("testRouterByType");
        this.routerSendService.routerString();
        this.routerSendService.routerInteger();
        return "hehe";
    }

}
