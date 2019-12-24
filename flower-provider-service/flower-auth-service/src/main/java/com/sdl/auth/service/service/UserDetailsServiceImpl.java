package com.sdl.auth.service.service;

import com.sdl.auth.client.CompetenceClient;
import com.sdl.common.base.enums.ResponseStatus;
import com.sdl.common.base.exception.BusinessException;
import com.sdl.common.entity.Menu;
import com.sdl.common.entity.Role;
import com.sdl.common.entity.User;
import com.sdl.common.utils.wrapper.Wrapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program flowerPaaS
 * @description: 用户认证
 * @author: songdeling
 * @create: 2019/12/23 17:29
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private CompetenceClient competenceClient;

    /**
     * 角色前缀
     */
    private static final String ROLE_PREFIX = "ROLE_";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 获取用户信息
        Wrapper<User> userWrapper = competenceClient.getUserByUsernameFromCTC(username);

        if (userWrapper.getCode() != ResponseStatus.SUCCESS.code()) {
            throw new BusinessException(userWrapper.getMessage());
        }

        User user = userWrapper.getResult();

        // 获取角色信息
        Wrapper<List<Role>> roleWrapper = competenceClient.getRoleByUserIdFromCTC(user.getId());
        //Wrapper<List<Role>> roleResult = competenceClient.getRoleByRoleIdFromCTC(user.getId());

        // 判断获取权限列表是否成功
        if (roleWrapper.getCode() != ResponseStatus.SUCCESS.code()) {
            throw new BusinessException(roleWrapper.getMessage());
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet();
        roleWrapper.getResult().stream().forEach(role -> {
            // 角色必须是 ROLE_ 开头，可以在数据库中设置（这里在程序中设置）
            grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getCode().toUpperCase()));

            // 获取菜单列表
            Wrapper<List<Menu>> menuWrapper = competenceClient.getMenuByRoleIdFromCTC(role.getId());
            // 判断获取菜单列表是否成功
            if (menuWrapper.getCode() != ResponseStatus.SUCCESS.code()) {
                throw new BusinessException(menuWrapper.getMessage());
            }
            menuWrapper.getResult().stream().forEach(menu -> grantedAuthorities.add(new SimpleGrantedAuthority(menu.getCode())));
        });

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getEnabled(),
                user.getAccountNonExpired(),
                user.getCredentialsNonExpired(),
                user.getAccountNonLocked(),
                grantedAuthorities);
    }
}
