package com.storage.controller;

import com.storage.entity.form.PlanDemandForm;
import com.storage.entity.form.PlanWarningForm;
import com.storage.entity.vo.PlanVo;
import com.storage.entity.vo.PurchaseVo;
import com.storage.service.PlanService;
import com.storage.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
            @ApiImplicitParam(paramType="Date", name = "dateBegin", value = "开始日期", required = true, dataType = "PlanForm"),
            @ApiImplicitParam(paramType="Date", name = "dateEnd", value = "结束日期", required = true, dataType = "PlanForm"),
            @ApiImplicitParam(paramType="String", name = "otherParameter", value = "其他参数指标", required = true, dataType = "PlanForm")
    })
    @PostMapping("/demandanalysis")
    public Result DemandAnalysis(PlanDemandForm planDemandForm){
        List<PlanVo> planVoList=planService.DemandAnalysis(planDemandForm);
        return Result.success(planVoList);
    }

    @ApiOperation("计算公式管理")
    @ApiImplicitParams({
    })
    @PostMapping("/formula")
    public Result Formula(){
        return Result.success();
    }

    @ApiOperation("更新库存预警")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="Integer", name = "branchId", value = "部门ID", required = true, dataType = "PlanForm"),
            @ApiImplicitParam(paramType="Integer", name = "goodsId", value = "商品ID", required = true, dataType = "PlanForm"),
            @ApiImplicitParam(paramType="Integer", name = "saleNum", value = "商品当前销售量", required = true, dataType = "PlanForm"),
            @ApiImplicitParam(paramType="Float", name = "increaseRate", value = "增长率", required = true, dataType = "PlanForm"),
            @ApiImplicitParam(paramType="Integer", name = "otherParameter", value = "其他参数指标", required = true, dataType = "PlanForm")
    })
    @PostMapping("/updatewarning")
    public Result UpdateWarning(List<PlanWarningForm> planWarningFormList){
        planService.UpdateWarning(planWarningFormList);
        return Result.success();
    }

    @ApiOperation("生成采购计划")
    @PostMapping("/createpurchase")
    public Result CreatePurchase(){
        List<PurchaseVo> purchaseVoList=planService.CreatePurchase();
        return Result.success(purchaseVoList);
    }

    @ApiOperation("生成其他报表")
    @ApiImplicitParams({
    })
    @PostMapping("/createreport")
    public Result CreateReport(){
        return Result.success();
    }
}
