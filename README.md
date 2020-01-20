## Spring Cloud整和项目 - FLOWERPaaS

[![Build Status](https://img.shields.io/badge/build-success-brightgreen)](https://github.com/CoderOfSong/flowerPaaS)[![Since](https://img.shields.io/badge/Since-2019-199EC4.svg)](https://github.com/CoderOfSong/flowerPaaS)[![Version](https://img.shields.io/badge/Version-1.0.0-orange.svg)](https://github.com/CoderOfSong/flowerPaaS)[![Java](https://img.shields.io/badge/Java-1.8-yellow.svg)](https://www.oracle.com/technetwork/java/javase/downloads/index.html)[![Maven](https://img.shields.io/badge/Maven-3.5.4-01BC7E.svg)](https://maven.apache.org/)[![Spring Boot](https://img.shields.io/badge/SpringBoot-2.1.0.RELEASE-FF69B4.svg)](https://spring.io/projects/spring-boot/)[![Spring Cloud](https://img.shields.io/badge/SpringCloud-Greenwich.RELEASE-5DBF3D.svg)](https://spring.io/projects/spring-cloud)[![Spring Cloud Alibaba](https://img.shields.io/badge/SpringCloudAlibaba-2.1.0.RELEASE-5DBF3D.svg)](https://spring.io/projects/spring-cloud)
-----
### 项目介绍

​		网上有关SpringCloud的教程很多，相关的项目也很多，但很少有整合完整的好项目，即便有也是基于1.x的版本，在这个技术迭代更新发展速度很快的时代，这样的项目不利于实际开发和落地。因此[flowerPaas](https://github.com/CoderOfSong/flowerPaaS)诞生了，它是一套完整的微服务体系框架，几乎包含了微服务所有常用组件，为了让中小型公司解决当下技术瓶颈，快速将现有技术架构拆分改造为微服务体系架构，只需在本框架上进行相关业务开发即可，大大减少了微服务架构的入门门槛，为中小企业实现微服务落地节省了大量时间。

​		本项目使用Maven构建，基于SpringBoot 2.1.0.RELEASE、SpringCloud Greenwich.RELEASE、SpringCloud Alibaba 2.1.0.RELEASE体系实现的微服务架构，采用OAuth2统一授权认证，支持Docker容器部署、限流、灰度发布等。

--------

### 核心组件介绍

```
- 服务注册、发现、配置中心: nacos
- 服务监控：spring boot admin
- 消息总线：spring cloud bus -> amqp
- 负载均衡：feign / ribbon
- 熔断降级：spring cloud alibaba sentinel
- 路由网关：gateway / zuul
- 链路追踪：spring cloud sletuh -> zipkin
- 安全认证：spring security -> oauth2
- ORM框架：mybatis
- 数据源监控：druid
- api文档输出：swagger2
- 分布式锁：redis（待实现）
- 消息队列：rabbitmq
- 分布式事物：3PC+TCC（待实现）
```

-----

### 平台目录结构说明

```
├── flowerPaaS·······················父项目，公共依赖
│   ├── DB···························初始化DB 
│   │
│   ├── flower-admin·················微服务监控中心
│   │
│   ├── flower-common················微服务公共包
│   │   ├── flower-common-base·······公共基础包
│   │   ├── flower-common-config·····公共配置包
│   │   ├── flower-common-core·······微服务核心依赖包
│   │   └── flower-common-utils······公共工具包
│   │
│   ├── flower-gateway···············微服务网关中心
│   │
│   ├── flower-provider-client·······服务消费者
│   │   └── flower-urm-client········用户管理服务消费者
│   │
│   ├── flower-provider-service······服务提供方
│   │   ├── flower-auth-service······鉴权服务提供方
│   │   └── flower-urm-service·······用户管理服务提供方
│   │
│   └── flower-zipkin················微服务日志采集中心
```

---------

### 开发环境及工具

```
- MacOS / Windows
- JDK 1.8
- IntelliJ IDEA
- maven
```

------

### 相关中间件及版本

| 名称                       | 版本    | 链接                                                         |
| :------------------------- | ------- | ------------------------------------------------------------ |
| Alibaba nacos              | v1.1.4  | [https://nacos.io/zh-cn/](https://nacos.io/zh-cn/)           |
| Alibaba sentinel-dashboard | v1.7.0  | [https://github.com/alibaba/Sentinel/releases/tag/1.7.0](https://github.com/alibaba/Sentinel/releases/tag/1.7.0) |
| MySql                      | v8.0.13 | [https://www.mysql.com](https://www.mysql.com)               |
| Redis                      | v5.0.2  | [https://redis.io](https://redis.io)                         |
| RabbitMQ                   | v3.7.9  | [https://www.rabbitmq.com](https://www.rabbitmq.com)         |

-------

### 项目架构图

（架构图）

------

### 项目运行

1. 下载项目，并且导入到IDEA中（步骤略）

2. 正常启动[nacos v1.1.4](https://nacos.io/zh-cn/)、[RabbitMQ v3.7.9](https://www.rabbitmq.com)、[MySql v8.0.13](https://www.mysql.com)、[Redis v5.0.2](https://redis.io)这4个必备中间件服务和[sentinel-dashboard v1.7.0](https://github.com/alibaba/Sentinel/releases/tag/1.7.0) 熔断降级，流量控制服务

   ```shell
   # nacos启动
   sh nacos/bin/startup.sh -m standalone
   
   # RabbitMQ启动
   systemctl start rabbitmq-server.service
   
   # MySQL Redis 启动略
   
   # 熔断降级，流量控制服务启动
   java -Dserver.port=8880 -Dcsp.sentinel.dashboard.server=localhost:8880 -Dproject.name=flower-sentinel-service -Dsentinel.dashboard.auth.username=admin -Dsentinel.dashboard.auth.password=admin -jar sentinel-dashboard.jar > /Users/songdeling/Desktop/test/logs/flower-sentinel.log.out 2>&1 &
   ```

3. 创建2个数据库分别为 flower_basics_dev、flower_zipkin_dev 并分别执行根目录 BD 中的 flower_basics.sql、flower_zipkin.sql 文件，创建整个项目必要的表

4. 修改项目的 resources/application.yml 配置文件中的datasource druid数据库连接信息

5. 修改项目的 resources/log4j2.yml 配置文件中的 -log.path value 日志输出路径

6. 启动服务，启动顺序如下

   ```
   flower-gateway
   flower-admin
   flower-zipkin
   flower-urm-service
   flower-auth-service
   ```

--------

### 效果展示

#### 服务注册/发现、配置中心















