package com.storage.mapper;

import com.storage.entity.vo.Menu;
import com.storage.entity.vo.Role;
import com.storage.entity.vo.PermissionVo;
import com.storage.entity.vo.UserLoginVo;
import com.storage.entity.vo.UserManageVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserLoginVo selectByUsername(String username, String password);
    List<PermissionVo> selectPerm(Long roleId);
    List<UserManageVo> selectUser(String code);
    List<UserManageVo> detailUser(Long userId);
    void insertUser(String code,String name,Long roleId);
    void updateUser(Long userId,String code,String password,String name,Long roleId);
    Role getRole();
    Menu getMenu();
    void delPerm(Long roleId);
    void addPerm(Long roleId,Long menuId);
}
