package com.pch.miniweibo.service.Impl;

import com.pch.miniweibo.VO.AuthUser;
import com.pch.miniweibo.VO.UserVO;
import com.pch.miniweibo.service.RoleTableService;
import com.pch.miniweibo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: MyUserDetailServiceImpl
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/20
 */
@Service
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleTableService roleService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO user = userService.getUserByName(username);
        if (user ==null){
            throw new UsernameNotFoundException(String.format("%s.这个用户不存在", username));
        }else {
            //查询用户对应的角色
            List<String> roles = roleService.getRoleByUserName(username);
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            for (String role : roles) {
                authorities.add(new SimpleGrantedAuthority(role));
            }
            System.out.println("loadUserByUsername......user ===> " + user);
            return new AuthUser(user.getUserName(),user.getPassWord(),user.getLockFlag(),authorities);
        }
    }
}
