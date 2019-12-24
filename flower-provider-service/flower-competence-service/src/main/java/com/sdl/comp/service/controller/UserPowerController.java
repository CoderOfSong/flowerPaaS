package com.sdl.comp.service.controller;

import com.sdl.common.utils.wrapper.WrapMapper;
import com.sdl.common.utils.wrapper.Wrapper;
import com.sdl.comp.service.entity.SysMenu;
import com.sdl.comp.service.entity.SysRole;
import com.sdl.comp.service.entity.SysUser;
import com.sdl.comp.service.repository.MenuRepository;
import com.sdl.comp.service.repository.RoleRepository;
import com.sdl.comp.service.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program flowerPaaS
 * @description: 用户权限管理
 * @author: songdeling
 * @create: 2019/12/24 12:01
 */
@Api("用户权限管理")
@RestController
@Slf4j
public class UserPowerController {
    @Resource
    private UserRepository userRepository;

    @Resource
    private RoleRepository roleRepository;

    @Resource
    private MenuRepository menuRepository;

    private static final String CACHE_KEY = "CACHE_COMP";

    @ApiOperation("根据用户名获取用户对象信息")
    @ApiParam(name = "username", value = "用户名", required = true)
    @GetMapping("/getUserByUsername/{username}")
    @Cacheable(cacheNames = CACHE_KEY + "_USER")
    public Wrapper getUserByUsername(@PathVariable String username) {

        // redis 自定义代码方式缓存使用
        /*
        String redisKey = "upms_user_" + username;
        ValueOperations<String, SysUser> operations = redisTemplate.opsForValue();
        Boolean hasKey = redisTemplate.hasKey(redisKey);
        if (hasKey) {
            SysUser user = operations.get(redisKey);
            operations.set(redisKey, user, 1000 * 5, TimeUnit.MILLISECONDS);    // 设置缓存及有效时间
            redisTemplate.delete(redisKey); // 删除缓存
        }
        */

        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser.setValid(true);

        SysUser user = userRepository.findOne(Example.of(sysUser)).orElse(null);

        if (user == null) {
            log.warn("用户[" + username + "]不存在");
            return WrapMapper.error("用户[" + username + "]不存在");
        }

        return WrapMapper.ok(user);
    }

    @ApiOperation("根据用户ID获取角色列表信息")
    @ApiParam(name = "userId", value = "用户ID", required = true)
    @GetMapping("/getRoleByUserId/{userId}")
    @Cacheable(cacheNames = CACHE_KEY + "_ROLE")
    public Wrapper getRoleByUserId(@PathVariable Integer userId) {
        List<SysRole> roleList = roleRepository.getRoleByUserId(userId);
        return WrapMapper.ok(roleList);
    }

    @ApiOperation("根据角色ID获取菜单列表信息")
    @ApiParam(name = "roleId", value = "角色ID", required = true)
    @GetMapping("/getMenuByRoleId/{roleId}")
    @Cacheable(cacheNames = CACHE_KEY + "_MENU")
    public Wrapper getMenuByRoleId(@PathVariable Integer roleId) {
        List<SysMenu> menuList = menuRepository.getMenuByRoleId(roleId);
        return WrapMapper.ok(menuList);
    }
}
