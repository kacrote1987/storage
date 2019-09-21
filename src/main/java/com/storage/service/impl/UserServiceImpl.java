package com.storage.service.impl;

import com.storage.entity.Menu;
import com.storage.entity.Permission;
import com.storage.entity.Role;
import com.storage.entity.form.LoginForm;
import com.storage.entity.form.PermForm;
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
import java.util.stream.Collectors;

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
        final List<PermissionVo> permissionVoList=userMapper.selectMenu(userLoginVo.getId());
        if(permissionVoList==null || permissionVoList.size()==0){
            throw new UnAuthorizationException("无法获取角色信息");
        }

        permissionVoList.forEach(item->PermissionVo.build(item,permissionVoList));

        userLoginVo.setPerms(permissionVoList.stream().filter(item->item.getPid()==0).collect(Collectors.toList()));

        return userLoginVo;
    }

    @Override
    public List<UserManageVo> select(String code) {
        List<UserManageVo> list=userMapper.selectUser(code);
        for(int i=0;i<list.size();i++){
            list.get(i).setPerms(userMapper.selectMenu(list.get(i).getRolerId()));
        }

        return list;
    }

    @Override
    public UserManageVo edit(Long userId) {
        UserManageVo userManageVo=userMapper.selectUserId(userId);
        userManageVo.setPerms(userMapper.selectMenu(userManageVo.getRolerId()));
        return userManageVo;
    }

    @Override
    public String save(UserManageVo form) {
        userMapper.saveUser(form.getId(),form.getName(),form.getRolerId());
        return "保存成功";
    }

    @Override
    public Role disprole() {
        Role role=userMapper.getRole();
        return role;
    }

    @Override
    public Menu dispmenu() {
        Menu menu=userMapper.getMenu();
        return menu;
    }

    @Override
    public List<PermissionVo> editperm(PermForm form) {
        userMapper.delPerm(form.getRoleId());
        for(int i=0;i<form.getPerms().size();i++){
            userMapper.addPerm(form.getPerms().get(i).getRoleId(),form.getPerms().get(i).getMenuId());
        }
        List<PermissionVo> permissionVoList=userMapper.selectMenu(form.getRoleId());
        return permissionVoList;
    }
}
