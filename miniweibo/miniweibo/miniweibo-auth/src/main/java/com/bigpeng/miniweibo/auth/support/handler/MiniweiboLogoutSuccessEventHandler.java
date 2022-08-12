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

package com.bigpeng.miniweibo.auth.support.handler;

import cn.hutool.core.collection.CollUtil;
import com.bigpeng.miniweibo.admin.api.entity.SysLog;
import com.bigpeng.miniweibo.common.core.util.SpringContextHolder;
import com.bigpeng.miniweibo.common.core.util.WebUtils;
import com.bigpeng.miniweibo.common.log.event.SysLogEvent;
import com.bigpeng.miniweibo.common.log.util.SysLogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.stereotype.Component;

/**
 * @author zhangran
 * @date 2022-06-02
 *
 * 事件机制处理退出相关
 */
@Slf4j
@Component
public class MiniweiboLogoutSuccessEventHandler implements ApplicationListener<LogoutSuccessEvent> {

	@Override
	public void onApplicationEvent(LogoutSuccessEvent event) {
		Authentication authentication = (Authentication) event.getSource();
		if (CollUtil.isNotEmpty(authentication.getAuthorities())) {
			handle(authentication);
		}
	}

	/**
	 * 处理退出成功方法
	 * <p>
	 * 获取到登录的authentication 对象
	 * @param authentication 登录对象
	 */
	public void handle(Authentication authentication) {
		log.info("用户：{} 退出成功", authentication.getPrincipal());
		SecurityContextHolder.getContext().setAuthentication(authentication);

		SysLog logVo = SysLogUtils.getSysLog();
		logVo.setTitle("退出成功");
		// 发送异步日志事件
		Long startTime = System.currentTimeMillis();
		Long endTime = System.currentTimeMillis();
		logVo.setTime(endTime - startTime);

		// 设置对应的token
		WebUtils.getRequest().ifPresent(request -> logVo.setParams(request.getHeader(HttpHeaders.AUTHORIZATION)));

		// 这边设置ServiceId
		if (authentication instanceof OAuth2Authorization) {
			OAuth2Authorization auth2Authentication = (OAuth2Authorization) authentication;
			logVo.setServiceId(auth2Authentication.getRegisteredClientId());
		}
		logVo.setCreateBy(authentication.getName());
		logVo.setUpdateBy(authentication.getName());
		SpringContextHolder.publishEvent(new SysLogEvent(logVo));
	}

}
