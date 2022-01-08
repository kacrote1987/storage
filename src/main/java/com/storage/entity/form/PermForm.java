package com.storage.entity.form;

import com.storage.entity.vo.Permission;

import java.util.List;

public class PermForm {
    private Long roleId;
    List<Permission> perms;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Permission> getPerms() {
        return perms;
    }

    public void setPerms(List<Permission> perms) {
        this.perms = perms;
    }
}
