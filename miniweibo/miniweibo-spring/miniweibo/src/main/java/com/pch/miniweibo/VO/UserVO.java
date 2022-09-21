package com.pch.miniweibo.VO;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @className: UserVO
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2022/9/20
 **/
@TableName("sys_user")
@Data
public class UserVO {
    private Integer userId;

    private String username;

    private String password;

    private String salt;

    private String phone;

    private String avatar;

    private Integer deptId;

    private Character lock_flag;

    private Character delFlag;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String createBy;

    private String updateBy;

    private Integer level;

    private String grade;
}
