package com.sdl.auth.service.config;

import com.sdl.auth.service.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @program flowerPaaS
 * @description: Web安全配置  ios
 * @author: songdeling
 * @create: 2019/12/23 17:20
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // 内存方式用户信息（仅测试）
        /*
        String finalPassword = "{bcrypt}" + new BCryptPasswordEncoder().encode("123456");
        auth
                .inMemoryAuthentication()
                .withUser("admin").password(finalPassword).authorities("READ", "WRITE")
                .and()
                .withUser("guest").password(finalPassword).authorities("READ");
                */

        // 数据库方式用户信息
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());

    }

}
