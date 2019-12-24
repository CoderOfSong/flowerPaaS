package com.sdl.auth.client.fallback;

import com.sdl.auth.client.CompetenceClient;
import com.sdl.common.utils.wrapper.WrapMapper;
import com.sdl.common.utils.wrapper.Wrapper;
import org.springframework.stereotype.Service;

/**
 * @program flowerPaaS
 * @description: CompetenceClient回调
 * @author: songdeling
 * @create: 2019/12/23 17:34
 */
@Service
public class CompetenceClientFallback implements CompetenceClient {
    @Override
    public Wrapper<Object> getUserByUsernameFromUpms(String username) {
        return WrapMapper.error("服务器开小差了~请稍后重试!");
    }

    @Override
    public Wrapper<Object> getRoleByUserIdFromUpms(Integer userId) {
        return WrapMapper.error("服务器开小差了~请稍后重试!");
    }

    @Override
    public Wrapper<Object> getMenuByRoleIdFromUpms(Integer roleId) {
        return WrapMapper.error("服务器开小差了~请稍后重试!");
    }
}
