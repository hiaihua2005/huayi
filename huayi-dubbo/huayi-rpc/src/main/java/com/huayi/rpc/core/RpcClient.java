package com.huayi.rpc.core;

import com.alipay.sofa.rpc.config.ConsumerConfig;
import com.huayi.rpc.service.ICardService;
import com.huayi.rpc.service.impl.CardService;

public class RpcClient {
    public static void main(String[] args) {
        ConsumerConfig<CardService> consumerConfig = new ConsumerConfig<CardService>()
                .setInterfaceId(ICardService.class.getName()) // 指定接口
                .setProtocol("bolt") // 指定协议
                .setDirectUrl("bolt://127.0.0.1:12200"); // 指定直连地址
        // 生成代理类
        ICardService cardService = consumerConfig.refer();
        while (true) {
            System.out.println(cardService.sayHello("world"));
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
        }
    }
}
