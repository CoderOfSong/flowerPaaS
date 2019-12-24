package com.sdl.gateway.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program flowerPaaS
 * @description: 网关服务启动器
 * @author: songdeling
 * @create: 2019/12/23 14:51
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }
}
