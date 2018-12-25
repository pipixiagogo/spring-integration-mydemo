package com.lin.integration.controller;

import com.lin.integration.dto.Test;
import com.lin.integration.service.PublishSubscribeService;
import com.lin.integration.service.SendService;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/test")
@Slf4j
public class TestChannleController {

    @Autowired
    private SendService sendService;

    @Autowired
    private PublishSubscribeService publishSubscribeService;

    /**
     * 测试传递dto参数
     * <p>
     * 接收类 {@link com.lin.integration.service.impl.ReceiveServiceImpl#hello(Test)}
     */
    @GetMapping("/testDto")
    public void testDto() {
        log.info("a><");
        System.out.println("testDto");
        sendService.testDto();
    }

    /**
     * 测试多参数传递方式，使用map传输，多参数接收
     * <p>
     * 接收类{@link com.lin.integration.service.impl.ReceiveServiceImpl#helloMoreParam(String, String)}
     */
    @GetMapping("/testMoreParam")
    public void testMoreParam() {
        System.out.println("testMoreParam");
        sendService.moreParamm();
    }

    /**
     * 测试网关模式dot，使用的是监控Interface
     * <p>
     * 接收类 {@link com.lin.integration.service.impl.ReceiveServiceImpl#hello(Test)}
     */
    @GetMapping("/getWay")
    public void getWay() {
        System.out.println("getWay");
        sendService.getWay();
    }

    /**
     * 测试网关模式多参数传递方式，使用的是监控Interface，使用map传输，多参数接收
     * <p>
     * 接收类 {@link com.lin.integration.service.impl.ReceiveServiceImpl#helloMoreParam(String, String)}
     */
    @GetMapping("/getWayMoreParam")
    public void getWayMoreParam() {
        System.out.println("getWayMoreParam");
        sendService.getWayMoreParam();
    }

    /**
     * 测试发布订阅模式
     * <p>
     * 接收类 {@link com.lin.integration.service.impl.ReceiveServiceImpl#helloReceiveOne(Test)}
     * 接收类 {@link com.lin.integration.service.impl.ReceiveServiceImpl#helloReceiveTwo(Test)}
     */
    @GetMapping("/pubsub")
    public void pubsub() {
        System.out.println("pubsub");
        publishSubscribeService.pubsubSend();
    }

    /**
     * 测试bridge
     * <p>
     * 接收类 {@link com.lin.integration.service.impl.ReceiveServiceImpl#helloBridge(String, String)}
     */
    @GetMapping("/birdgeSend")
    public void birdgeSend() {
        System.out.println("birdgeSend");
        sendService.bridgeSend();
    }

    /**
     * 测试filter
     * <p>
     * 接收类 {@link com.lin.integration.service.impl.ReceiveServiceImpl#helloMoreParam(String, String)}
     */
    @GetMapping("/filterSend")
    public void filterSend(String name) {
        System.out.println("filterSend");
        sendService.filterSend(name);
    }

    /**
     * 测试transformer
     * <p>
     * 接收类 {@link com.lin.integration.service.impl.ReceiveServiceImpl#helloTransformer(String)}
     */
    @GetMapping("/transformerSend")
    public void transformerSend(String name) {
        System.out.println("transformerSend");
        sendService.transformerSend(name);
    }
}
