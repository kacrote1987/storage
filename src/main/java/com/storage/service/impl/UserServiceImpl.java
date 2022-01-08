package com.storage.service.impl;

import com.storage.entity.vo.Menu;
import com.storage.entity.vo.Role;
import com.storage.entity.form.LoginForm;
import com.storage.entity.form.PermForm;
import com.storage.entity.form.UserEditForm;
import com.storage.entity.form.UserNewForm;
import com.storage.entity.vo.UserLoginVo;
import com.storage.entity.vo.PermissionVo;
import com.storage.entity.vo.UserManageVo;
import com.storage.exception.UnAuthorizationException;
import com.storage.mapper.UserMapper;
import com.storage.service.UserService;
import com.storage.util.MyCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public UserLoginVo login(LoginForm form) {
        UserLoginVo userLoginVo=userMapper.selectByUsername(form.getUsername(),form.getPassword());
        if(userLoginVo==null){
            throw new UnAuthorizationException("用户名或密码错误");
        }
        userLoginVo.setToken(UUID.randomUUID().toString());
        MyCache.put(userLoginVo.getToken(),userLoginVo,30, TimeUnit.MINUTES);
        final List<PermissionVo> permissionVoList=userMapper.selectPerm(userLoginVo.getRoleId());
        if(permissionVoList==null || permissionVoList.size()==0){
            throw new UnAuthorizationException("无法获取角色信息");
        }

//        permissionVoList.forEach(item->PermissionVo.build(item,permissionVoList));
//
//        userLoginVo.setPerms(permissionVoList.stream().filter(item->item.getPid()==0).collect(Collectors.toList()));

        return userLoginVo;
    }

    @Override
    public List<UserManageVo> select(String code) {
        List<UserManageVo> list=userMapper.selectUser(code);
        for(int i=0;i<list.size();i++){
            list.get(i).setPerms(userMapper.selectPerm(list.get(i).getRoleId()));
        }
        return list;
    }

    @Override
    public List<UserManageVo> detail(Long userId) {
        List<UserManageVo> list=userMapper.detailUser(userId);
        for(int i=0;i<list.size();i++){
            list.get(i).setPerms(userMapper.selectPerm(list.get(i).getRoleId()));
        }
        return list;
    }

    @Override
    public void insert(UserNewForm form) {
        userMapper.insertUser(form.getCode(),form.getName(),form.getRoleId());
    }

    @Override
    public void edit(UserEditForm form) {
        userMapper.updateUser(form.getUserId(),form.getCode(),form.getPassword(),form.getName(),form.getRoleId());
    }

    @Override
    public Role allroles() {
        Role roles=userMapper.getRole();
        return roles;
    }

    @Override
    public Menu allmenus() {
        Menu menus=userMapper.getMenu();
        return menus;
    }

    @Override
    public List<PermissionVo> permdetail(Long roleId) {
        List<PermissionVo> list=userMapper.selectPerm(roleId);
        return list;
    }

    @Override
    public void editperm(PermForm perms) {
        userMapper.delPerm(perms.getRoleId());
        for(int i=0;i<=perms.getPerms().size();i++){
            userMapper.addPerm(perms.getPerms().get(i).getRoleId(),perms.getPerms().get(i).getMenuId());
        }
    }

}
