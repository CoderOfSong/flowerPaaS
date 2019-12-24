package com.sdl.comp.service.repository;

import com.sdl.common.base.repository.BaseRepository;
import com.sdl.comp.service.entity.SysUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @program flowerPaaS
 * @description:
 * @author: songdeling
 * @create: 2019/12/24 14:05
 */
@Component
@Repository
public interface UserRepository extends BaseRepository<SysUser, Integer> {
}
