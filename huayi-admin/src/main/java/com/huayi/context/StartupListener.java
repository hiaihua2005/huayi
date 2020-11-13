package com.huayi.context;

import com.huayi.framework.cache.ShardedRedisUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class StartupListener implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        ShardedRedisUtil.set("a1","a1");
        System.out.println(ShardedRedisUtil.get("a1"));
    }
}
