package com.storage.service;

import com.storage.entity.form.LoginForm;
import com.storage.entity.vo.UserLoginVo;

public interface UserService {
    /**
     * 登陆
     */
    UserLoginVo login(LoginForm form);
}
