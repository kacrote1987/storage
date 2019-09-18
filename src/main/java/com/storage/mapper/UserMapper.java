package com.storage.mapper;

import com.storage.entity.Menu;
import com.storage.entity.Role;
import com.storage.entity.vo.PermissionVo;
import com.storage.entity.vo.UserLoginVo;
import com.storage.entity.vo.UserManageVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserLoginVo selectByUsername(String username, String password);
    List<PermissionVo> selectMenu(Long roleId);
    List<UserManageVo> selectUser(String code);
    UserManageVo selectUserId(Long userId);
    void saveUser(Long id,String name,Long roleId);
    Role getRole();
    Menu getMenu();
}
