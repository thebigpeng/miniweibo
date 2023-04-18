package com.pch.miniweibo.Api.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pch.miniweibo.Api.UserService;
import com.pch.miniweibo.Dao.UserMapper;
import com.pch.miniweibo.VO.UserVO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserVO> implements UserService {

    @Override
    public UserVO getUserByName(String username) {
        QueryWrapper<UserVO> queryWrapper = new QueryWrapper<>();

        return null;
    }

    @Override
    public boolean loginCheck(String username, String password) {
        return false;
    }
}
