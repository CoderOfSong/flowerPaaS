package com.sdl.auth.service.controller;

import com.sdl.common.wrapper.WrapMapper;
import com.sdl.common.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @program flowerPaaS
 * @description: 用户认证控制层
 * @author: songdeling
 * @create: 2019/12/24 10:58
 */
@Api("用户认证")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private ConsumerTokenServices consumerTokenServices;

    @ApiOperation(value = "获取用户凭证信息", response = Wrapper.class)
    @GetMapping(value = "/principal")
    public Wrapper principal(Principal principal) {
        //获取用户凭证信息
        return WrapMapper.ok(principal);
    }

    @ApiOperation(value = "移除用户凭证信息", response = Wrapper.class)
    @DeleteMapping(value = "/revoke")
    public Wrapper revoke(String access_token) {
        if (consumerTokenServices.revokeToken(access_token)) {
            return WrapMapper.ok();
        } else {
            return WrapMapper.error("移除用户凭证信息失败");
        }
    }
}
