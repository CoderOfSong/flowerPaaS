package com.sdl.urm.service.service;

import com.sdl.urm.service.entity.SysRole;

import java.util.List;

public interface IRoleService {
    List<SysRole> getRoleByUserId(Integer userId);
}
