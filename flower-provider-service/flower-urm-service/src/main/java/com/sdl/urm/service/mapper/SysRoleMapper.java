package com.sdl.urm.service.mapper;


import com.sdl.urm.service.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMapper {
    List<SysRole> selectRoleByUserId(Integer userId);
}