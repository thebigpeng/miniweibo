package com.pch.miniweibo.Api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pch.miniweibo.VO.UserVO;

public interface UserService extends IService<UserVO> {

    /**
     * 通过账号查询用户
     *
     * @param username
     * @return
     */
    UserVO getUserByName(String username);

    boolean loginCheck(String username, String password) throws Exception;

    /**
     * 注册
     * @param userVO
     * @return
     * @throws Exception
     */
    boolean register(UserVO userVO) throws Exception;

    UserVO voToPo(UserVO vo);


}
