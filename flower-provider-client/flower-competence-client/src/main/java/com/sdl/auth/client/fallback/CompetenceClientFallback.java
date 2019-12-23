package com.sdl.auth.client.fallback;

import com.sdl.auth.client.CompetenceClient;
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
    public Result<BIConversion.User> getUserByUsernameFromUpms(String username) {
        return null;
    }

    @Override
    public Result<List<Role>> getRoleByUserIdFromUpms(Integer userId) {
        return null;
    }

    @Override
    public Result<List<Menu>> getMenuByRoleIdFromUpms(Integer roleId) {
        return null;
    }
}
