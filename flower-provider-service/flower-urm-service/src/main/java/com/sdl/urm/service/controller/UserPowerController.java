package com.sdl.urm.service.controller;

import com.sdl.common.wrapper.WrapMapper;
import com.sdl.common.wrapper.Wrapper;
import com.sdl.urm.service.entity.SysMenu;
import com.sdl.urm.service.entity.SysRole;
import com.sdl.urm.service.entity.SysUser;
import com.sdl.urm.service.service.IMenuService;
import com.sdl.urm.service.service.IRoleService;
import com.sdl.urm.service.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
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
    private IMenuService iMenuService;
    @Resource
    private IUserService iUserService;
    @Resource
    private IRoleService iRoleService;

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

        SysUser user = iUserService.findOne(sysUser);

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
        List<SysRole> roleList = iRoleService.getRoleByUserId(userId);
        return WrapMapper.ok(roleList);
    }

    @ApiOperation("根据角色ID获取菜单列表信息")
    @ApiParam(name = "roleId", value = "角色ID", required = true)
    @GetMapping("/getMenuByRoleId/{roleId}")
    @Cacheable(cacheNames = CACHE_KEY + "_MENU")
    public Wrapper getMenuByRoleId(@PathVariable Integer roleId) {
        List<SysMenu> menuList = iMenuService.getMenuByRoleId(roleId);
        return WrapMapper.ok(menuList);
    }
}
