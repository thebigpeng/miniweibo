package com.pch.miniweibo.Utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @className: BCryptPasswordEncoderUtil
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/18
 */
@Component
public class BCryptPasswordEncoderUtil extends BCryptPasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return super.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return super.matches(rawPassword, encodedPassword);
    }
}
