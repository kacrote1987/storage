package com.storage.service;

import com.storage.entity.vo.Menu;
import com.storage.entity.vo.Role;
import com.storage.entity.form.LoginForm;
import com.storage.entity.form.PermForm;
import com.storage.entity.form.UserEditForm;
import com.storage.entity.form.UserNewForm;
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
     * 用户查询
     */
    List<UserManageVo> select(String code);
    /**
     * 用户详细
     */
    List<UserManageVo> detail(Long userId);
    /**
     * 用户新增
     */
    void insert(UserNewForm form);
    /**
     * 用户修改
     */
    void edit(UserEditForm form);
    /**
     * 所有角色列表
     */
    Role allroles();
    /**
     * 所有权限列表
     */
    Menu allmenus();
    /**
     * 某角色权限列表
     */
    List<PermissionVo> permdetail(Long roleId);
    /**
     * 修改权限
     */
    void editperm(PermForm perms);
}
