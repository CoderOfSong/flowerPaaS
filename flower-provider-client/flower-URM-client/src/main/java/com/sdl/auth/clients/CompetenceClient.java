package com.sdl.auth.clients;

import com.sdl.auth.clients.fallback.CompetenceClientFallback;
import com.sdl.common.entity.Menu;
import com.sdl.common.entity.Role;
import com.sdl.common.entity.User;
import com.sdl.common.utils.wrapper.Wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @program flowerPaaS
 * @description:
 * @author: songdeling
 * @create: 2019/12/25 12:46
 */
@FeignClient(name = "flower-competence-service", fallback = CompetenceClientFallback.class)
public interface CompetenceClient {
    @GetMapping("/getUserByUsername/{username}")
    Wrapper<User> getUserByUsernameFromCTC(@PathVariable("username") String username);

    @GetMapping("/getRoleByUserId/{userId}")
    Wrapper<List<Role>> getRoleByUserIdFromCTC(@PathVariable("userId") Integer userId);

    @GetMapping("/getMenuByRoleId/{roleId}")
    Wrapper<List<Menu>> getMenuByRoleIdFromCTC(@PathVariable("roleId") Integer roleId);
}