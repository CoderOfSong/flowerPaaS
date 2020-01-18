package com.sdl.comp.service.service;

import com.sdl.comp.service.entity.SysMenu;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMenuService {
    List<SysMenu> getMenuByRoleId(Integer roleId);
}
