package com.huayi;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * @EnableDubbo一定要加，否则启动后dubbo服务无法加载
 * @author huayi
 */
@EnableDubbo
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan("com.huayi.*.mapper")
public class ScrmApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(ScrmApplication.class, args);
        System.out.println("  HuaYi-Scrm启动成功   ");

    }
}