package com.pch.miniweibo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.net.PasswordAuthentication;

/**
 * @className: SecurityConfiguration
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2022/9/20
 **/
@Configuration
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder getPw(){
        return new BCryptPasswordEncoder();
    }
}
