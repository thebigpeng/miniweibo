package com.pch.miniweibo.config.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: MyAuthenticationSuccessHandler
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/18
 */
public class MyAuthenticationSuccessHandler extends JSONAuthentication
    implements AuthenticationSuccessHandler {
  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException, ServletException {

  }
}
