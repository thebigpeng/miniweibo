package com.pch.miniweibo.VO;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @className: AuthUser
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/20
 */
@Component
public class AuthUser implements UserDetails {

  private String username;

  private String password;

  private Integer state;

  public Integer getState() {
    return state;
  }

  @Override
  public String toString() {
    return "JwtUser{"
        + "username='"
        + username
        + '\''
        + ", password='"
        + password
        + '\''
        + ", state="
        + state
        + ", authorities="
        + authorities
        + '}';
  }

  public void setState(Integer state) {
    this.state = state;
  }

  private Collection<? extends GrantedAuthority> authorities;

  public AuthUser() {}

  public AuthUser(
      String username,
      String password,
      Integer state,
      Collection<? extends GrantedAuthority> authorities) {
    this.username = username;
    this.password = password;
    this.state = state;
    this.authorities = authorities;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
