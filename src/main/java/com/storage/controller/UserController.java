package com.storage.controller;

import com.storage.entity.vo.Menu;
import com.storage.entity.vo.Role;
import com.storage.entity.form.LoginForm;
import com.storage.entity.form.PermForm;
import com.storage.entity.form.UserNewForm;
import com.storage.entity.form.UserEditForm;
import com.storage.entity.vo.PermissionVo;
import com.storage.entity.vo.UserLoginVo;
import com.storage.entity.vo.UserManageVo;
import com.storage.service.UserService;
import com.storage.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "password", value = "密码", required = true, dataType = "String")
    })
    @PostMapping("/login")
    public Result login(@RequestBody @Valid LoginForm form){
        UserLoginVo userVo= userService.login(form);
        return Result.success(userVo);
    }

    @ApiOperation("用户查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "code", value = "用户名/姓名", required = true, dataType = "String")
    })
    @GetMapping("/select")
    public Result select(String code){
        List<UserManageVo> list= userService.select(code);
        return Result.success(list);
    }

    @ApiOperation("用户详细")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "userId", value = "用户ID", required = true, dataType = "Long")
    })
    @GetMapping("/detail")
    public Result detail(Long userId){
        List<UserManageVo> list=userService.detail(userId);
        return Result.success(list);
    }

    @ApiOperation("用户新增")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "code", value = "用户名(初始密码与用户名相同)", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "name", value = "姓名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "roleId", value = "角色ID", required = true, dataType = "Long")
    })
    @GetMapping("/add")
    public Result add(@RequestBody @Valid UserNewForm form){
        userService.insert(form);
        return Result.success();
    }

    @ApiOperation("用户修改")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "userId", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(paramType="query", name = "code", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "password", value = "密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "name", value = "姓名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "roleId", value = "角色ID", required = true, dataType = "Long")
    })
    @GetMapping("/edit")
    public Result edit(@RequestBody @Valid UserEditForm form){
        userService.edit(form);
        return Result.success();
    }

    @ApiOperation("所有角色列表")
    @PostMapping("/allroles")
    public Result allroles(){
        Role roles= userService.allroles();
        return Result.success(roles);
    }

    @ApiOperation("所有权限列表")
    @PostMapping("/allmenus")
    public Result allmenus(){
        Menu menus= userService.allmenus();
        return Result.success(menus);
    }

    @ApiOperation("某角色权限列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "roleId", value = "角色ID", required = true, dataType = "Long")
    })
    @PostMapping("/permdetail")
    public Result permdetail(Long roleId){
        List<PermissionVo> list= userService.permdetail(roleId);
        return Result.success(list);
    }

    @ApiOperation("某角色权限修改")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "perms", value = "新的权限", required = true, dataType = "PermForm")
    })
    @PostMapping("/editperm")
    public Result editperm(PermForm perms){
        userService.editperm(perms);
        return Result.success();
    }
}
