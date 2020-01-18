package com.sdl.urm.service.mapper;


import com.sdl.urm.service.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysMenuMapper {
    List<SysMenu> getMenuByRoleId(@Param("roleId") Integer roleId);
}