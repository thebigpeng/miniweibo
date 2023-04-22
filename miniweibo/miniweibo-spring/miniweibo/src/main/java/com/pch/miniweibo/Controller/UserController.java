package com.pch.miniweibo.Controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.pch.miniweibo.service.UserService;
import com.pch.miniweibo.VO.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController extends ApiController {

  @Autowired UserService userService;

  public String login() {
    return "redirect:main.html";
  }

  @PostMapping("register")
  public R userRegister(@RequestBody(required = false) UserVO userVO) {
    try {
      System.out.println("registerVo = " + userVO);
      return success(userService.register(userVO));
    } catch (Exception e) {
      return failed(e.getMessage());
    }
    //        return new ResponseResult(new UserVO(), StatusEnum.REGISIT_FAILD.getCode(),
    // StatusEnum.REGISIT_FAILD.getDesc());
  }
}
