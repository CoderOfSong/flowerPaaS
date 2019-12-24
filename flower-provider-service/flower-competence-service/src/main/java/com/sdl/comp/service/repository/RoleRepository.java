package com.sdl.comp.service.repository;

import com.sdl.comp.service.entity.SysRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface RoleRepository  {

    /**
     * 占位符风格
     */
    @Query(value = "select r.* from sys_role r, sys_user_role ur where r.id=ur.role_id and r.valid=1 and ur.valid=1 and ur.user_id=?1", nativeQuery = true)
    List<SysRole> getRoleByUserId(Integer userId);
}
