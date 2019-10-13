package com.storage.controller;

import com.storage.service.PlanService;
import com.storage.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 该模块未完成
 */
@Api(description = "采购计划管理")
@RestController
@RequestMapping("/plan")
public class PlanController {
    @Resource
    PlanService planService;

    @ApiOperation("客户需求分析")
    @ApiImplicitParams({
    })
    @PostMapping("/demandanalysis")
    public Result demandanalysis(){
        return Result.success();
    }

    @ApiOperation("生成采购单")
    @ApiImplicitParams({
    })
    @PostMapping("/createpurchase")
    public Result createpurchase(){
        return Result.success();
    }
}
