package com.storage.controller;

import com.storage.entity.Menu;
import com.storage.entity.Role;
import com.storage.entity.form.LoginForm;
import com.storage.entity.vo.UserLoginVo;
import com.storage.entity.vo.UserManageVo;
import com.storage.service.UserService;
import com.storage.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;
    @PostMapping("/login")
    public Result login(@RequestBody @Valid LoginForm form){
        UserLoginVo userVo= userService.login(form);
        return Result.success(userVo);
    }
    @GetMapping("/select")
    public Result select(String code){
        List<UserManageVo> list= userService.select(code);
        return Result.success(list);
    }
    @GetMapping("/edit")
    public Result edit(Long userId){
        UserManageVo userManageVo= userService.edit(userId);
        return Result.success(userManageVo);
    }
    @GetMapping("/save")
    public Result save(@RequestBody @Valid UserManageVo form){
        userService.save(form);
        return null;
    }
    @PostMapping("/disprole")
    public Result disprole(){
        Role role= userService.disprole();
        return Result.success(role);
    }
    @PostMapping("/dispmenu")
    public Result dispmenu(){
        Menu menu= userService.dispmenu();
        return Result.success(menu);
    }
}
