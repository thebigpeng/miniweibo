package com.pch.miniweibo.config.auth;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: MyAccessDeniedHandler
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/22
 */
@Component
public class MyAccessDeniedHandler extends JSONAuthentication implements AccessDeniedHandler {
  @Override
  public void handle(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      AccessDeniedException e)
      throws IOException, ServletException {
    R<String> data = R.failed(String.format("权限不足：{}", e.getMessage()));
    this.WriteJSON(httpServletRequest,httpServletResponse,data);
  }
}
