package com.pch.miniweibo.config.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @className: MyUsernamePasswordAuthenticationFilter
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/18
 **/
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        if (request.getContentType().equals(MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE) || request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
            ObjectMapper mapper = new ObjectMapper();
            UsernamePasswordAuthenticationToken authenticationToken = null;
            //取authenticationBean
            Map<String, String> authenticationBean = null;
            //用try with resource，方便自动释放资源
            try (InputStream inputStream = request.getInputStream()) {
                authenticationBean = mapper.readValue(inputStream, Map.class);
            } catch (IOException e) {
                //将异常放到自定义的异常类中

            }

            try {
                if (!authenticationBean.isEmpty()){
                    //获取传入的账号和密码
                    String username = authenticationBean.get(SPRING_SECURITY_FORM_USERNAME_KEY);
                    String password = authenticationBean.get(SPRING_SECURITY_FORM_PASSWORD_KEY);

                    //验证账号密码的正确性
                    if (true){

                    }
                }
            }catch (Exception e){

            }
        }

        return super.attemptAuthentication(request, response);
    }
}
