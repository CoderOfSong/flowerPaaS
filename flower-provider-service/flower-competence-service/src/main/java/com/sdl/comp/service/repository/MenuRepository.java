package com.sdl.comp.service.repository;

import com.sdl.comp.service.entity.SysMenu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository {

    /**
     * SPEL表达式风格
     */
    @Query(value = "select m.* from sys_menu m,sys_role_menu rm where m.id=rm.menu_id and m.valid=1 and rm.valid=1 and rm.role_id=:roleId", nativeQuery = true)
    List<SysMenu> getMenuByRoleId(@Param("roleId") Integer roleId);
}
