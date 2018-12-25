package com.lin.integrationjava.controller;

import com.lin.integrationjava.service.SendService;
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
@RequestMapping("/testInterceptor")
public class TestInterceptorChannleController {
//
//    @Autowired
//    private SendService sendService;

    /**
     * 测试拦截器
     */
//    @GetMapping("/testInterceptor")
//    public void testInterceptor() {
//        System.out.println("testInterceptor");
//        sendService.testInterceptor();
//    }

}
