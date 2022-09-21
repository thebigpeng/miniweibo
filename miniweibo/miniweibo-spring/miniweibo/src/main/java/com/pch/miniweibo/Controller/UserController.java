package com.pch.miniweibo.Controller;

import com.pch.miniweibo.Enums.StatusEnum;
import com.pch.miniweibo.VO.ResponseResult;
import com.pch.miniweibo.VO.UserVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    public String login(){
        return "redirect:main.html";
    }

    @PostMapping("/regist")
    public ResponseResult<UserVO> userRegister(){


        return new ResponseResult(new UserVO(), StatusEnum.REGISIT_FAILD.getCode(), StatusEnum.REGISIT_FAILD.getDesc());
    }

}
