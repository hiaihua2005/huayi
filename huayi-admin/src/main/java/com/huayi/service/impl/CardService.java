package com.huayi.service.impl;

import com.huayi.service.ICardService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * 注意：Service是dubbo的service，不能是spring的
 */
@Component
@Service
public class CardService  implements ICardService {

    @Override
    public String sayHello(String world) {
        return "Hello "+world;
    }

}
