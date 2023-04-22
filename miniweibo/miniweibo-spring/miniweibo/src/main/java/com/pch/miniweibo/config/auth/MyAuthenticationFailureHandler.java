package com.pch.miniweibo.config.auth;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @className: MyAuthenticationFailureHandler
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/20
 */
@Component
public class MyAuthenticationFailureHandler extends JSONAuthentication implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        R<String> data = R.failed("登录失败： "+e.getMessage());
        this.WriteJSON(request,response,data);
    }
}
