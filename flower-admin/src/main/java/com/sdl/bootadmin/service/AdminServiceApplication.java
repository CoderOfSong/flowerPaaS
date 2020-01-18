package com.sdl.bootadmin.service;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import io.netty.channel.ChannelOption;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

/**
 * @program flowerPaaS
 * @description: 服务监控
 * @author: songdeling
 * @create: 2019/12/23 15:31
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class AdminServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminServiceApplication.class, args);
    }
}
