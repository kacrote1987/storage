package com.storage.controller;

import com.storage.entity.form.CustomerForm;
import com.storage.entity.vo.*;
import com.storage.service.CustomerService;
import com.storage.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Api(description = "客户管理")
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    CustomerService customerService;

    @ApiOperation("客户查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "code", value = "会员卡号/手机号码/身份证号码", required = true, dataType = "String")
    })
    @GetMapping("/select")
    public Result select(String code){
        List<CustomerVo> list= customerService.select(code);
        return Result.success(list);
    }

    @ApiOperation("获取当前客户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "code", value = "会员卡号/手机号码/身份证号码", required = true, dataType = "String")
    })
    @GetMapping("/getcustomerid")
    public Result getcustomerid(String code){
        Long id=customerService.getcustomerid(code);
        return Result.success(id);
    }

    @ApiOperation("开户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="String", name = "name", value = "姓名", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="Integer", name = "idCard", value = "身份证号码", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="Integer", name = "tel", value = "电话号码", required = true, dataType = "Form")
    })
    @GetMapping("/register")
    public Result register(@RequestBody @Valid CustomerForm customerForm){
        customerService.register(customerForm);
        return Result.success();
    }

    @ApiOperation("注销")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="Integer", name = "id", value = "客户ID", required = true, dataType = "Integer")
    })
    @PostMapping("/unregister")
    public Result unregister(Long id){
        customerService.unregister(id);
        return Result.success();
    }
}
