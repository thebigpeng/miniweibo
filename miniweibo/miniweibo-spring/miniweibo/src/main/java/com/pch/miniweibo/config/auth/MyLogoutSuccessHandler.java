package com.pch.miniweibo.config.auth;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: MyLogoutSuccessHandler
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/22
 */
@Component
public class MyLogoutSuccessHandler extends JSONAuthentication implements LogoutSuccessHandler {
  @Override
  public void onLogoutSuccess(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      Authentication authentication)
      throws IOException, ServletException {
    System.out.printf("退出成功");
    R<String> data = R.ok("退出成功!");
    this.WriteJSON(httpServletRequest, httpServletResponse, data);
  }
}
