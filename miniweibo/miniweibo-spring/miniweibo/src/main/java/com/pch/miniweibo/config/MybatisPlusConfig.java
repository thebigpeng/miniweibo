package com.pch.miniweibo.config;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @className: MybatisPlusConfig
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2022/9/20
 **/
@Configuration
@EnableTransactionManagement
public class MybatisPlusConfig {
    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor(){
        return new PaginationInnerInterceptor();
    }
}
