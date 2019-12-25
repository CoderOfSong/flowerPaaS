package com.sdl.comp.service.service.impl;

import com.sdl.comp.service.entity.SysRole;
import com.sdl.comp.service.mapper.SysRoleMapper;
import com.sdl.comp.service.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program flowerPaaS
 * @description:
 * @author: songdeling
 * @create: 2019/12/25 10:48
 */
@Service
@Slf4j
public class RoleServiceImpl implements IRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> getRoleByUserId(Integer userId) {
        return sysRoleMapper.selectRoleByUserId(userId);
    }
}
