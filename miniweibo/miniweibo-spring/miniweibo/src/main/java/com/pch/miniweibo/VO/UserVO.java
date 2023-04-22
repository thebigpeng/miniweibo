package com.pch.miniweibo.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @className: UserVO
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2022/9/20
 */
@TableName("sys_user_table")
@Data
public class UserVO {
  @TableId(type = IdType.UUID)
  private String userId;

  private String userName;

  /** 用户密码-BCR算法加密 */
  private String passWord;

  /** 描述 */
  private String description;

  /** 状态 */
  private Integer state;

  private String salt;

  private String phone;

  private String avatar;

  // 1--锁定；0--有效
  private Integer lockFlag;

  // 1--已删除；0--未删除
  private Integer delFlag;

  private LocalDateTime createTime;

  private LocalDateTime updateTime;

  private String createBy;

  private String updateBy;

  private Integer level;

  private Integer grade;
}
