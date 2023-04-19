package com.pch.miniweibo.Enums;

import org.springframework.security.core.AuthenticationException;

/**
 * @className: MyException
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/19
 */
public class MyAuthenticationException extends AuthenticationException {
  public MyAuthenticationException(String msg) {
    super(msg);
  }
}
