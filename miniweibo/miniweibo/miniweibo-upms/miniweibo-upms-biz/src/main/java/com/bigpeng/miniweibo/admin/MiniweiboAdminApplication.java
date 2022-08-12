/*
 * Copyright (c) 2020 miniweibo4cloud Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bigpeng.miniweibo.admin;

import com.bigpeng.miniweibo.common.feign.annotation.EnableMiniweiboFeignClients;
import com.bigpeng.miniweibo.common.security.annotation.EnableMiniweiboResourceServer;
import com.bigpeng.miniweibo.common.swagger.annotation.EnableMiniweiboDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lengleng
 * @date 2018年06月21日 用户统一管理系统
 */
@EnableMiniweiboDoc
@EnableMiniweiboResourceServer
@EnableMiniweiboFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MiniweiboAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniweiboAdminApplication.class, args);
	}

}
