package com.lin.integration.aop;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 拦截器
 *
 * @author lin
 */
@Component
public class CountingChannelInterceptor extends ChannelInterceptorAdapter {

    private final static String HEADER_IGNORE_CODE = "id,timestamp";

    /**
     * 发送前
     *
     * @param message
     * @param channel
     * @return
     */
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        if(message == null){
            return null;
        }
        MessageBuilder<?> objectMessageBuilder = MessageBuilder.withPayload(message.getPayload());
        MessageHeaders headers = message.getHeaders();
        objectMessageBuilder.setHeader("integrationUserInfo","a");
        for(String key :headers.keySet()){
            if(HEADER_IGNORE_CODE.contains(key)){
                continue;
            }
            objectMessageBuilder.setHeader(key,headers.get(key));
        }
        Message<?> messageSend = objectMessageBuilder.build();
        System.out.println("preSend");
        return messageSend;
    }

    /**
     * 寄出前
     *
     * @param message
     * @param channel
     * @param sent
     */
    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
        System.out.println("postSend");
    }

    /**
     * 发送完成后
     *
     * @param message
     * @param channel
     * @param sent
     * @param ex
     */
    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
        System.out.println("afterSendCompletion");
    }

    /**
     * 接收前
     *
     * @param channel
     * @return
     */
    @Override
    public boolean preReceive(MessageChannel channel) {
        System.out.println("preReceive");
        return true;
    }

    /**
     * 接收后（暂未测试）
     *
     * @param message
     * @param channel
     * @return
     */
    @Override
    public Message<?> postReceive(Message<?> message, MessageChannel channel) {
        System.out.println("postReceive");
        return message;
    }

    /**
     * 接收完成后
     *
     * @param message
     * @param channel
     * @param ex
     */
    @Override
    public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
        System.out.println("afterReceiveCompletion");
    }
}
