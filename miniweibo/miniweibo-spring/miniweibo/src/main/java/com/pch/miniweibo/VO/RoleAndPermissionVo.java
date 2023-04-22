package com.pch.miniweibo.VO;
/**
 * @className: RoleAndPermissionVo
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/20
 */
public class RoleAndPermissionVo {
  String id;
  String name;
  String roleId;
  String pid;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }

  @Override
  public String toString() {
    return "SysUserRoleVo{"
        + "id='"
        + id
        + '\''
        + ", name='"
        + name
        + '\''
        + ", roleId='"
        + roleId
        + '\''
        + ", pid='"
        + pid
        + '\''
        + '}';
  }
}
