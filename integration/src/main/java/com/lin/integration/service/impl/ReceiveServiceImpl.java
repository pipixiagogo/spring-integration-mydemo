package com.lin.integration.service.impl;

import com.lin.integration.dto.Test;
import org.springframework.stereotype.Service;

/**
 * @author lin
 */
@Service
public class ReceiveServiceImpl implements com.lin.integration.service.ReceiveService {

    @Override
    public void hello(Test test) {
        System.out.println(test.getName() + " " + test.getAge());
    }

    @Override
    public void helloMoreParam(String name, String age) {
        System.out.println(name + " " + age);
    }

    @Override
    public void helloReceiveOne(Test test) {
        System.out.println("One:" + test.getName() + " " + test.getAge());
    }

    @Override
    public void helloReceiveTwo(Test test) {
        System.out.println("Two:" + test.getName() + " " + test.getAge());
    }

    @Override
    public void helloReceiveThree(String name, String age) {
        System.out.println("Three:" + name + " " + age);
    }

    @Override
    public void helloRouterTest(Test test) {
        System.out.println("routerA方法");
        System.out.println("helloRouterTest:" + test.getName() + " " + test.getAge());
    }

    @Override
    public void helloRouterMap(String name, String age) {
        System.out.println("routerB方法");
        System.out.println("helloRouterMap:" + name + " " + age);
    }

    @Override
    public void routerString(String str) {
        System.out.println("routerString方法");
        System.out.println("routerString:" + str);
    }
    @Override
    public void routerInteger(Integer a) {
        System.out.println("routerInteger");
        System.out.println("routerInteger:" + a);
    }

    @Override
    public void helloBridge(String name, String age) {
        System.out.println("helloBridge:" + name + " " + age);
    }

    @Override
    public void helloTransformer(String name) {
        System.out.println("helloTransformer:" + name);
    }

    @Override
    public void helloNoParam() {
        System.out.println("haha hehe");
    }

}