package com.sdl.comp.service.mapper;


import com.sdl.comp.service.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMapper {
    List<SysRole> selectRoleByUserId(Integer userId);
}