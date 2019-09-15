package com.storage.service.impl;

import com.storage.entity.form.LoginForm;
import com.storage.entity.vo.UserLoginVo;
import com.storage.entity.vo.PermissionVo;
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
        List<PermissionVo> permissionVoList=userMapper.selectMenu(userLoginVo.getId());
        if(permissionVoList==null || permissionVoList.size()==0){
            throw new UnAuthorizationException("无法获取角色信息");
        }
        permissionVoList=PermissionVo.buildTree(permissionVoList);
        userLoginVo.setPerms(permissionVoList);
        return userLoginVo;
    }
}
