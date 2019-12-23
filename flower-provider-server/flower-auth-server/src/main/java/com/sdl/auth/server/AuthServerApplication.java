package com.sdl.auth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @program flowerPaaS
 * @description: 鉴权服务启动器
 * @author: songdeling
 * @create: 2019/12/23 17:20
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.sdl.auth.client")
@ComponentScan(basePackages = {"com.sdl.common", "com.sdl.auth"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {ScheduleConfig.class})})
public class AuthServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }
}
