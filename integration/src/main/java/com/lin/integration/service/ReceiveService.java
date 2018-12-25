package com.lin.integration.service;

import com.lin.integration.dto.Test;

public interface ReceiveService {
    void hello(Test test);

    void helloMoreParam(String name, String age);

    void helloReceiveOne(Test test);

    void helloReceiveTwo(Test test);

    void helloReceiveThree(String name, String age);

    void helloRouterTest(Test test);

    void helloRouterMap(String name, String age);

    void routerString(String str);

    void routerInteger(Integer a);

    void helloBridge(String name, String age);

    void helloTransformer(String name);

    void helloNoParam();
}
