package com.pch.miniweibo.config;

import com.pch.miniweibo.config.auth.MyAuthenticationSuccessHandler;
import com.pch.miniweibo.config.auth.MyUsernamePasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

/**
 * @className: WebSecurityConfigurer
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/18
 */
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

  // 登录成功处理器
  @Autowired private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;



  @Override
  protected void configure(HttpSecurity http) throws Exception {

    // 第1步：解决跨域问题。cors 预检请求放行,让Spring security 放行所有preflight request（cors 预检请求）
    http.authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest).permitAll();

    // 第2步：让Security永远不会创建HttpSession，它不会使用HttpSession来获取SecurityContext
    http.csrf()
        .disable()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .headers()
        .cacheControl();

    // 第3步：请求权限配置
    // 放行注册API请求，其它任何请求都必须经过身份验证.
    http.authorizeRequests()
        .antMatchers(HttpMethod.POST, "/user/register")
        .permitAll()
        // ROLE_ADMIN可以操作任何事情
        // .antMatchers("/**").hasRole("ADMIN")
        // 同等上一行代码
        // .antMatchers("/**").hasAuthority("ROLE_ADMIN")
        /*
        由于使用动态资源配置，以上代码在数据库中配置如下：
        在sys_backend_api_table中添加一条记录
        backend_api_id=1，
        backend_api_name = 所有API，
        backend_api_url=/**,
        backend_api_method=GET,POST,PUT,DELETE
        */

        // 动态加载资源
        .anyRequest()
            .access("@dynamicPermission.checkPermisstion(request,authentication)");

    //第4步：拦截账号、密码。覆盖 UsernamePasswordAuthenticationFilter过滤器
    http.addFilterAt(myUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    // 第7步：登录,因为使用前端发送JSON方式进行登录，所以登录模式不设置也是可以的。
    http.formLogin();
  }

  /**
   * 手动注册账号、密码拦截器
   *
   * @return
   * @throws Exception
   */
  @Bean
  MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter() throws Exception {
    MyUsernamePasswordAuthenticationFilter filter = new MyUsernamePasswordAuthenticationFilter();
    // 成功后处理
    filter.setAuthenticationSuccessHandler(myAuthenticationSuccessHandler);
    // 失败后处理
    //    filter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);

    filter.setAuthenticationManager(authenticationManagerBean());
    return filter;
  }
}
