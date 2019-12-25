package com.sdl.comp.service.service;

import com.sdl.comp.service.entity.SysRole;

import java.util.List;

public interface IRoleService {
    List<SysRole> getRoleByUserId(Integer userId);
}
