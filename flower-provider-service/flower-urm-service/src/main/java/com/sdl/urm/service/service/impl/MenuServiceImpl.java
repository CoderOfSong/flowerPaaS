package com.sdl.urm.service.service.impl;

import com.sdl.urm.service.entity.SysMenu;
import com.sdl.urm.service.mapper.SysMenuMapper;
import com.sdl.urm.service.service.IMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program flowerPaaS
 * @description:
 * @author: songdeling
 * @create: 2019/12/25 10:10
 */
@Service
@Slf4j
public class MenuServiceImpl implements IMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;


    @Override
    public List<SysMenu> getMenuByRoleId(Integer roleId) {
        return sysMenuMapper.getMenuByRoleId(roleId);
    }
}
