package com.sdl.urm.service.service;

import com.sdl.urm.service.entity.SysMenu;

import java.util.List;

public interface IMenuService {
    List<SysMenu> getMenuByRoleId(Integer roleId);
}
