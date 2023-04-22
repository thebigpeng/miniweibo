package com.pch.miniweibo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.pch.miniweibo.Dao")
@EnableTransactionManagement
public class MiniweiboApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniweiboApplication.class, args);
    }

}
