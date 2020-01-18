package com.sdl.urm.service.mapper;

import com.sdl.urm.service.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserMapper {
    SysUser selectByUserName(@Param("username") String username, @Param("valid") Boolean valid);
}