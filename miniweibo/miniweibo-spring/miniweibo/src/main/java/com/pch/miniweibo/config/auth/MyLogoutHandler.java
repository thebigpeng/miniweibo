package com.pch.miniweibo.config.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @className: MyLogoutHandler
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/22
 */
@Component
public class MyLogoutHandler extends JSONAuthentication implements LogoutHandler {

  private String header = "Authorization";

  @Override
  public void logout(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      Authentication authentication) {
    String headToken = httpServletRequest.getHeader(header);
    System.out.printf("headToken: "+headToken);
    if (!StringUtils.isEmpty(headToken)){
      String token = headToken.replace("Bearer", "").trim();
      System.out.println("authentication = " + authentication);
      SecurityContextHolder.clearContext();
    }
  }
}
