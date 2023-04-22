package com.pch.miniweibo.config.auth;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: MyAuthenticationEntryPoint
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/22
 */
@Component
public class MyAuthenticationEntryPoint extends JSONAuthentication
    implements AuthenticationEntryPoint {
  @Override
  public void commence(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      AuthenticationException e)
      throws IOException, ServletException {
    R<String> data = R.failed(String.format("访问此资源需要完备的身份认证 () !", e.getMessage()));
    this.WriteJSON(httpServletRequest, httpServletResponse, data);
  }
}
