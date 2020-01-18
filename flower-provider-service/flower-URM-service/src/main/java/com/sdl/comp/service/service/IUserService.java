package com.sdl.comp.service.service;

import com.sdl.comp.service.entity.SysUser;
import org.springframework.data.domain.Example;

import java.util.Optional;

public interface IUserService {
    SysUser findOne(SysUser sysUser);
}
