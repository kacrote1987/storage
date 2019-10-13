package com.storage.controller;

import com.github.pagehelper.Page;
import com.storage.entity.form.OrderForm;
import com.storage.entity.form.ShopSelectForm;
import com.storage.entity.vo.GoodsList;
import com.storage.entity.vo.Producer;
import com.storage.entity.vo.ShopVo;
import com.storage.service.ShopService;
import com.storage.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(description = "门店管理")
@RestController
@RequestMapping("/shop")
public class ShopController {
    @Resource
    ShopService shopService;

    @ApiOperation("门店库存查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="Integer", name = "id", value = "门店ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="String", name = "code", value = "商品代码/商品名称（支持模糊查询）", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="Integer", name = "pageNo", value = "页数", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="Integer", name = "pageSize", value = "每页显示记录数", required = true, dataType = "Form")
    })
    @PostMapping("/select")
    public Result select(@RequestBody ShopSelectForm shopSelectForm){
        Page<ShopVo> list= shopService.select(shopSelectForm);
        return Result.success(list);
    }

    @ApiOperation("商品列表")
    @PostMapping("/goodslist")
    public Result goodslist(){
        GoodsList goodslist= shopService.goodslist();
        return Result.success(goodslist);
    }

    @ApiOperation("供应商列表")
    @PostMapping("/producerlist")
    public Result producerlist(){
        Producer producerlist= shopService.producerlist();
        return Result.success(producerlist);
    }

    @ApiOperation("补货")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="List", name = "orderForm", value = "订单", required = true, dataType = "Form")
    })
    @PostMapping("/supply")
    public Result supply(OrderForm orderForm){
        shopService.supply(orderForm);
        return Result.success();
    }

    @ApiOperation("零售")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="Integer", name = "userId", value = "操作员ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="Integer", name = "goodsId", value = "商品ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="Integer", name = "num", value = "数量", required = true, dataType = "Integer")
    })
    @PostMapping("/sale")
    public Result sale(Long userId,Long goodsId,Long num){
        shopService.sale(userId,goodsId,num);
        return Result.success();
    }
}
