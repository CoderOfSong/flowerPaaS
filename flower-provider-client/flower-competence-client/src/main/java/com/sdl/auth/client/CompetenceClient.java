package com.sdl.auth.client;

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
@FeignClient(name = "flower-competence-server", fallback = CompetenceClientFallback.class)
public interface CompetenceClient {
    @GetMapping("/getUserByUsername/{username}")
    Result<BIConversion.User> getUserByUsernameFromUpms(@PathVariable("username") String username);

    @GetMapping("/getRoleByUserId/{userId}")
    Result<List<Role>> getRoleByUserIdFromUpms(@PathVariable("userId") Integer userId);

    @GetMapping("/getMenuByRoleId/{roleId}")
    Result<List<Menu>> getMenuByRoleIdFromUpms(@PathVariable("roleId") Integer roleId);
}
