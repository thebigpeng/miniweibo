package com.pch.miniweibo.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pch.miniweibo.service.UserService;
import com.pch.miniweibo.dao.UserMapper;
import com.pch.miniweibo.Utils.BCryptPasswordEncoderUtil;
import com.pch.miniweibo.VO.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserVO> implements UserService {

  // 用户锁定状态
  private static final int USER_LOCK_STATE = 0;

  // 用户有效
  private static final int USER_DELETE_STATE = 0;

  @Autowired
  BCryptPasswordEncoderUtil bCryptPasswordEncoder;

  @Override
  public UserVO getUserByName(String username) {
    LambdaQueryWrapper<UserVO> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper
        .eq(UserVO::getUserName, username)
        .eq(UserVO::getLockFlag, USER_LOCK_STATE)
        .eq(UserVO::getDelFlag, USER_DELETE_STATE);
    UserVO userVO = this.getOne(queryWrapper);
    return userVO;
  }

  /**
   * 登陆验证
   *
   * @param username
   * @param password
   * @return
   */
  @Override
  public boolean loginCheck(String username, String password) throws Exception {
    UserVO userVO = this.getUserByName(username);
    System.out.printf("userVO: " + userVO.toString());
    if (userVO == null) {
      throw new Exception("账号不存在!");
    } else {
      String encodePwd = userVO.getPassWord();
      if (!bCryptPasswordEncoder.matches(password, encodePwd)) {
        throw new Exception("密码不正确！");
      } else {
        return true;
      }
    }
  }

  @Override
  public boolean register(UserVO userVO) throws Exception {

    if (userVO != null) {
      UserVO user = this.getUserByName(userVO.getUserName());
      if (user != null) {
        throw new Exception("这个用户已经存在，不能重复。");
      }
      // 保存到数据库
      return this.save(this.voToPo(userVO));
    } else {
      throw new Exception("错误消息：用户对象为空！");
    }
  }

  @Override
  public UserVO voToPo(UserVO vo) {
    UserVO userVO = new UserVO();
    userVO.setUserName(vo.getUserName());
    userVO.setPassWord(bCryptPasswordEncoder.encode(vo.getPassWord()));
    userVO.setDelFlag(0);
    userVO.setLockFlag(0);
    userVO.setPhone(vo.getPhone());
    return userVO;
  }
}
