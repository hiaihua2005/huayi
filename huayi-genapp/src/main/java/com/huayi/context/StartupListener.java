package com.huayi.context;

import com.huayi.framework.cache.ShardedRedisUtil;
import com.huayi.generator.service.IGenService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;


@Component
public class StartupListener implements CommandLineRunner {

    @Autowired
    IGenService genService;

    @Override
    public void run(String... args) throws Exception {
        ShardedRedisUtil.set("a1","a1");

        System.out.println(ShardedRedisUtil.get("a1"));
        String tableName = "t_business_settings";
        byte[] data = genService.generatorCode(tableName,"BusinessSetting");
        File outFile = new File("/Users/shiaihua/xinlingshou/tmp/"+tableName+".zip");
        IOUtils.write(data, new FileOutputStream(outFile));
    }
}
