package com.huayi.rpc.service.impl;

import com.huayi.rpc.service.ICardService;
import org.springframework.stereotype.Service;

@Service
public class CardService  implements ICardService {

    @Override
    public boolean sayHello(String world) {
        return true;
    }
}
