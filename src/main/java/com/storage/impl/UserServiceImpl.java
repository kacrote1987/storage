package com.storage.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.storage.entity.*;
import com.storage.mapper.UserMapper;
import com.storage.service.UserService;
import com.storage.config.MyCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
//    @Resource

    @Override
    public LoginVo login(LoginForm params) {
        LoginVo userLoginVo=userMapper.login(params.getUserCode(),params.getUserPwd());
        System.out.println(userLoginVo.getUserState());
        if(userLoginVo!=null){
            userLoginVo.setToken(UUID.randomUUID().toString());
            MyCache.put(userLoginVo.getToken(),userLoginVo,30, TimeUnit.MINUTES);
        }
//        final List<PermissionVo> permissionVoList=userMapper.selectPerm(userLoginVo.getRoleId());
//        if(permissionVoList==null || permissionVoList.size()==0){
//            throw new UnAuthorizationException("无法获取角色信息");
//        }
//        permissionVoList.forEach(item->PermissionVo.build(item,permissionVoList));
//        userLoginVo.setPerms(permissionVoList.stream().filter(item->item.getPid()==0).collect(Collectors.toList()));
        return userLoginVo;
    }

    public PageInfo<UserListVo> userList(UserListForm params) {
        Integer page = 0;
        if(params.getPage() != null){
            page = params.getPage();
        }
        PageHelper.startPage(page, 10);
        String type;
        if(params.getType()==null || params.getType().equals("")){
            type="dept";
        }else{
            type=params.getType();
        }
        List<UserListVo> userList=userMapper.userList(type,params);
        return PageInfo.of(userList);
    }

    @Override
    public List<UserDetVo> userDet(Long userId) {
        List<UserDetVo> userDet=null;
        if(userId!=0){
            userDet=userMapper.selDet(userId);
        }
        return userDet;
    }

    public static String method (String str){
        String pos1;
        String pos2=null;
        for (int i = 0; i < str.length(); i++) {
            char c=str.charAt(i); //把字符串转为字符
            if(c >= 'A' && c <= 'Z'){
                pos1=str.replace(c,(char)(c+32));
                pos2=pos1.substring(0,i)+'_'+pos1.substring(i,pos1.length());
            }
        }
        return pos2;
    }
}
