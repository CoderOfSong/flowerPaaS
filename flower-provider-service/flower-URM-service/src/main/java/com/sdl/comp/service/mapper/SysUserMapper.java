package com.sdl.comp.service.mapper;

import com.sdl.comp.service.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserMapper {
    SysUser selectByUserName(@Param("username") String username, @Param("valid") Boolean valid);
}