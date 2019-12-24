package com.sdl.auth.service.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @program flowerPaaS
 * @description: 自定义认证异常
 * @author: songdeling
 * @create: 2019/12/24 10:53
 */
@JsonSerialize(using = CustomOAuth2ExceptionSerializer.class)
public class CustomOAuth2Exception extends OAuth2Exception {

    private int code;

    CustomOAuth2Exception(int code, String msg) {
        super(msg);
        this.code = code;
    }

    @Override
    public int getHttpErrorCode() {
        return this.code;
    }

}
