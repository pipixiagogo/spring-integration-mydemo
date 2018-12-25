package com.lin.integrationjava.config;

import com.lin.integrationjava.dto.Message;
import com.lin.integrationjava.dto.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.PollerSpec;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.MessageChannel;

/**
 * spring-integration通道的配置文件
 *
 * @author lin
 * @date 2018年10月03日
 */
@Configuration
public class IntegrationChannelConfig {

    /**************************************发送端 start**************************************************************/
    /**
     * 静态注入channel方式
     *
     * @return
     */
    @Bean
    public MessageChannel testChannel() {
        return MessageChannels.queue().get();
    }

    @Bean
    public MessageChannel publishSubscribeChannel() {
        return MessageChannels.publishSubscribe().get();
    }

    @Bean
    public MessageChannel publishSubscribe2Channel() {
        return MessageChannels.publishSubscribe().get();
    }

    @Bean
    public MessageChannel testRouteChannel() {
        return MessageChannels.queue().get();
    }


    @Bean
    public MessageChannel testRouteChannel1() {
        return MessageChannels.queue().get();
    }

    @Bean
    public MessageChannel testRouteChannel2() {
        return MessageChannels.queue().get();
    }

    /**
     * 默认的全局poller值
     *
     * @return
     */
    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerSpec poller() {
        return Pollers.fixedRate(500)
                .errorChannel("myErrors");
    }


    /**
     * 静态注入bean接收方式
     *
     * @return
     */
    @Bean
    public IntegrationFlow testChannelReceiver() {
        return IntegrationFlows.from("testChannel")
                //直接输出
                .handle(s -> System.out.println(((Test) s.getPayload()).getName() + " " + ((Test) s.getPayload()).getAge()))
                .get();
    }
    /**************************************发送端 end****************************************************************/


    /**************************************接收端 start**************************************************************/
    @Bean
    public IntegrationFlow pubsubChannelReceiver() {
        return IntegrationFlows.from("input")
                .fixedSubscriberChannel()
                .channel("publishSubscribeChannel")
                .channel("publishSubscribe2Channel")
                //.channel(publishSubscribe2Channel()) 这种订阅方式也可以
                .handle(s -> System.out.println(((Test) s.getPayload()).getName() + " " + ((Test) s.getPayload()).getAge()))
                .get();
    }

    /**
     * route路由使用 start
     **/
    @Bean
    public IntegrationFlow routeChannelReceiver1() {
        return IntegrationFlows.from("testRouteChannel1")
                .handle(s -> System.out.println("routeChannelReceiver1  "+((Test) s.getPayload()).getName() + " " + ((Test) s.getPayload()).getAge()))
                .get();
    }

    @Bean
    public IntegrationFlow routeChannelReceiver2() {
        return IntegrationFlows.from("testRouteChannel2")
                .handle(s -> System.out.println("routeChannelReceiver2  "+((Test) s.getPayload()).getName() + " " + ((Test) s.getPayload()).getAge()))
                .get();
    }

    @Bean
    public IntegrationFlow routeChannelReceiver() {
        return IntegrationFlows.from("testRouteChannel")
                .<Test, Boolean>route(p -> p.getAge().equals("18"),
                        m -> m.channelMapping(true, "testRouteChannel1")//如果是18岁就进入channel1
                                .channelMapping(false, "testRouteChannel2")//如果不是就进入channel2
                )
                .get();
    }
    /** route路由使用 end  **/
    /**************************************接收端 end****************************************************************/

}
