package com.bigpeng.miniweibo.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bigpeng.miniweibo.admin.api.dto.UserInfo;
import com.bigpeng.miniweibo.admin.api.entity.SysUser;
import com.bigpeng.miniweibo.admin.service.AppService;
import com.bigpeng.miniweibo.admin.service.SysUserService;
import com.bigpeng.miniweibo.common.core.exception.ErrorCodes;
import com.bigpeng.miniweibo.common.core.util.MsgUtils;
import com.bigpeng.miniweibo.common.core.util.R;
import com.bigpeng.miniweibo.common.security.annotation.Inner;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lengleng
 * @date 2021/9/16 移动端登录
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app")
@Tag(name = "移动端登录模块")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class AppController {

	private final AppService appService;

	private final SysUserService userService;

	@Inner(value = false)
	@GetMapping("/{mobile}")
	public R<Boolean> sendSmsCode(@PathVariable String mobile) {
		return appService.sendSmsCode(mobile);
	}

	/**
	 * 获取指定用户全部信息
	 * @param phone 手机号
	 * @return 用户信息
	 */
	@Inner
	@GetMapping("/info/{phone}")
	public R<UserInfo> infoByMobile(@PathVariable String phone) {
		SysUser user = userService.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getPhone, phone));
		if (user == null) {
			return R.failed(MsgUtils.getMessage(ErrorCodes.SYS_USER_USERINFO_EMPTY, phone));
		}
		return R.ok(userService.getUserInfo(user));
	}

}
