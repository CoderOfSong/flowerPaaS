package com.sdl.comp.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program flowerPaaS
 * @description: 用户管理服务启动器
 * @author: songdeling
 * @create: 2019/12/24 11:46
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.sdl.common.base.mapper", "com.sdl.comp.service..*.mapper"})
@ComponentScan(basePackages = {"com.sdl.common.*", "com.sdl.comp.service.*"})
public class CompServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompServiceApplication.class, args);
    }
}
