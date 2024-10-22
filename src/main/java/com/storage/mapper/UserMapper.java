package com.storage.mapper;

import com.storage.entity.LoginVo;
import com.storage.entity.UserDetVo;
import com.storage.entity.UserListForm;
import com.storage.entity.UserListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    LoginVo login(String userCode, String userPwd);
    List<UserListVo> userList(String type, @Param("params") UserListForm params);
    List<UserDetVo> selDet(Long userId);
}
