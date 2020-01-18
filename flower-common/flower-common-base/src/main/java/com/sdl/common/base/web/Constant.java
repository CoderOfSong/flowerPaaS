package com.sdl.common.base.web;

import org.apache.http.HttpStatus;

/**
 * @program flowerPaaS
 * @description: 统一常量池
 * @author: songdeling
 * @create: 2019/12/23 14:16 Add library 'Maven: org.apache.httpcomponents:httpcore:4.4.8' to classpath
 */
public class Constant {
    public static final Boolean DEL_FALSE = false;
    public static final Boolean ABLE_TRUE = true;

    public static class Code implements HttpStatus {

        // feign客户端调用失败
        public final static int SC_FEIGN_FALLBACK = 5001;

    }

    public static class Message {
        public final static String SC_OK = "操作成功.";
        public final static String SC_INTERNAL_SERVER_ERROR = "操作失败(服务器内部错误).";
        public final static String SC_FEIGN_FALLBACK = "服务器开小差了~请稍后重试!";
        public final static String SC_FORBIDDEN = "没有权限访问该资源~";
        public final static String SC_UNAUTHORIZED = "授权失败~";
    }

    /**
     * 微服务名统一管理
     */
    public static class Service {
        public final static String UYW_EUREKA = "uyw-eureka";
        public final static String UYW_DISCOVERY = "uyw-discovery";
        public final static String UYW_GATEWAY = "uyw-gateway";
        public final static String UYW_AUTH = "uyw-auth";
        public final static String UYW_ZIPKIN = "uyw-zipkin";
        public final static String UYW_MONITOR = "uyw-monitor";
    }

    public static class Auth {
        public final static String TOKEN_HEADER = "Authorization";
        public final static String TOKEN_VALUE_PREV = "Bearer ";
        // TODO: JWT签名
        public final static String JWT_SIGNING_KEY = "flowerPaaS";
    }
}
