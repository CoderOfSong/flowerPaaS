package com.sdl.auth.client.fallback;

import com.sdl.auth.client.CompetenceClient;
import com.sdl.common.entity.Menu;
import com.sdl.common.entity.Role;
import com.sdl.common.entity.User;
import com.sdl.common.utils.wrapper.WrapMapper;
import com.sdl.common.utils.wrapper.Wrapper;
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
