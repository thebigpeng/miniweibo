package com.pch.miniweibo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @className: AccessControlAllowOriginFilter
 * @description: 解决跨域问题
 * @author: pengchenhui
 * @date: 2023/4/22
 */
@Configuration
public class AccessControlAllowOriginFilter extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("POST","GET","PUT","DELETE","OPTIONS")
                .allowedHeaders("*").exposedHeaders("access-control-allow-headers",
                        "access-control-allow-methods",
                        "access-control-allow-origin",
                        "access-control-max-age",
                        "X-Frame-Options").allowCredentials(true).maxAge(3600);
    }
}
