package com.sdl.zipkin.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @program flowerPaaS
 * @description: 链路追踪服务启动器
 * @author: songdeling
 * @create: 2019/12/23 16:00
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZipkinServer
public class ZipkinServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServiceApplication.class, args);
    }
}
