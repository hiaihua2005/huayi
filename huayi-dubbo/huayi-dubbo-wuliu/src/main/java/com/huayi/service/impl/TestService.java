package com.huayi.service.impl;

import com.huayi.service.ITestMe;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * 注意：Service是dubbo的service，不能是spring的
 */
@Component
@Service
public class TestService implements ITestMe {

    @Override
    public String testMe() {
        return "Who am I......";
    }
}
