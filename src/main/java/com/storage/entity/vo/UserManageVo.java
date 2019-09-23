package com.storage.entity.vo;

import java.util.List;

public class UserManageVo {
    private Long userId;
    private String name;
    private String code;
    private Long roleId;
    private String roleName;
    List<PermissionVo> perms;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<PermissionVo> getPerms() {
        return perms;
    }

    public void setPerms(List<PermissionVo> perms) {
        this.perms = perms;
    }
}
