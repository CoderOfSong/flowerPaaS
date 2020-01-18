package com.sdl.auth.clients.fallback;

import com.sdl.auth.clients.CompetenceClient;
import com.sdl.common.base.entity.Menu;
import com.sdl.common.base.entity.Role;
import com.sdl.common.base.entity.User;
import com.sdl.common.wrapper.WrapMapper;
import com.sdl.common.wrapper.Wrapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program flowerPaaS
 * @description: CompetenceClient回调
 * @author: songdeling
 * @create: 2019/12/23 17:34
 */
@Service
public class CompetenceClientFallback implements CompetenceClient {
    @Override
    public Wrapper<User> getUserByUsernameFromCTC(String username) {
        return WrapMapper.error("用户权限管理服务开小差了~请稍后重试!");
    }

    @Override
    public Wrapper<List<Role>> getRoleByUserIdFromCTC(Integer userId) {
        return WrapMapper.error("用户权限管理服务开小差了~请稍后重试!");
    }

    @Override
    public Wrapper<List<Menu>> getMenuByRoleIdFromCTC(Integer roleId) {
        return WrapMapper.error("用户权限管理服务开小差了~请稍后重试!");
    }
}
