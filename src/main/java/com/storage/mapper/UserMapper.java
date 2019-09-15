package com.storage.mapper;

import com.storage.entity.vo.PermissionVo;
import com.storage.entity.vo.UserLoginVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserLoginVo selectByUsername(String username, String password);
    List<PermissionVo> selectMenu(Long roleId);
}
