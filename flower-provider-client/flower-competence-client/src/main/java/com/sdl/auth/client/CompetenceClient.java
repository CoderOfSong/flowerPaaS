package com.sdl.auth.client;

import com.sdl.auth.client.fallback.CompetenceClientFallback;
import com.sdl.common.entity.Menu;
import com.sdl.common.entity.Role;
import com.sdl.common.entity.User;
import com.sdl.common.utils.wrapper.Wrapper;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @program flowerPaaS
 * @description: CompetenceFeignClient
 * @author: songdeling
 * @create: 2019/12/23 17:20
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
