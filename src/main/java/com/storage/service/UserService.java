package com.storage.service;

import com.storage.entity.Menu;
import com.storage.entity.Permission;
import com.storage.entity.Role;
import com.storage.entity.form.LoginForm;
import com.storage.entity.form.PermForm;
import com.storage.entity.vo.PermissionVo;
import com.storage.entity.vo.UserLoginVo;
import com.storage.entity.vo.UserManageVo;

import java.util.List;

public interface UserService {
    /**
     * 登陆
     */
    UserLoginVo login(LoginForm form);
    /**
     * 用户管理
     */
    List<UserManageVo> select(String code);
    /**
     * 用户详细
     */
    UserManageVo edit(Long userId);
    /**
     * 用户保存
     */
    String save(UserManageVo form);
    /**
     * 展示所有角色
     */
    Role disprole();
    /**
     * 展示所有权限
     */
    Menu dispmenu();
    /**
     * 修改权限
     */
    List<PermissionVo> editperm(PermForm form);
}
