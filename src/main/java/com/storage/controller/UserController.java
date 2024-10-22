package com.storage.controller;

import com.github.pagehelper.PageInfo;
import com.storage.entity.*;
import com.storage.service.UserService;
import com.storage.config.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Api(description = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @ApiOperation("登陆")
    @PostMapping("/login")
    public Result login(@RequestBody @Valid LoginForm params){
        LoginVo userLoginVo= userService.login(params);
        return Result.success(userLoginVo);
    }

    @ApiOperation("用户信息列表")
    @PostMapping("/userList")
    public Result userList(UserListForm params){
        PageInfo<UserListVo> userList= userService.userList(params);
        return Result.success(userList);
    }

    @ApiOperation("用户详细信息")
    @PostMapping("/userDet")
    public Result userDet(@RequestBody Long userId){
        List<UserDetVo> userDet=userService.userDet(userId);
        return Result.success(userDet);
    }
}
