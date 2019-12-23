package com.sdl.base.exception;

import com.sdl.base.enums.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * @program flowerPaaS
 * @description: 业务异常类
 * @author: songdeling
 * @create: 2019/12/23 13:52
 */
@Slf4j
public class BusinessException extends RuntimeException {

    /**
     * 异常码
     */
    protected int code;

    private static final long serialVersionUID = 3160241586346324995L;

    public BusinessException() {
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
    }

    public BusinessException(ErrorCodeEnum codeEnum, Object... args) {
        super(String.format(codeEnum.msg(), args));
        this.code = codeEnum.code();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
