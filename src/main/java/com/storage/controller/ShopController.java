package com.storage.controller;

import com.github.pagehelper.Page;
import com.storage.entity.form.OrderForm;
import com.storage.entity.form.ShopSelectForm;
import com.storage.entity.vo.*;
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

    @ApiOperation("扫描会员卡获取会员信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="String", name = "vipcard", value = "会员卡号", required = true, dataType = "String")
    })
    @PostMapping("/scancard")
    public Result scanCard(String vipCard){
        CustomerVo customerVo=shopService.scanCard(vipCard);
        return Result.success(customerVo);
    }

    @ApiOperation("扫描商品生成订单")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="List", name = "orderForm", value = "订单", required = true, dataType = "Form")
    })
    @PostMapping("/createorder")
    public Result createOrder(OrderForm orderForm){
        OrderVo orderVo=shopService.createOrder(orderForm);
        return Result.success(orderVo);
    }

    @ApiOperation("订单取消")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="Integer", name = "orderId", value = "订单ID", required = true, dataType = "Integer")
    })
    @PostMapping("/cancel")
    public Result cancel(Long orderId){
        shopService.cancel(orderId);
        return Result.success();
    }

    @ApiOperation("订单结算")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="List", name = "orderForm", value = "订单", required = true, dataType = "Form")
    })
    @PostMapping("/sale")
    public Result sale(OrderForm orderForm){
        shopService.sale(orderForm);
        return Result.success();
    }

    @ApiOperation("打印订单")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="List", name = "orderForm", value = "订单", required = true, dataType = "Form")
    })
    @PostMapping("/printorder")
    public Result printOrder(OrderForm orderForm){
        shopService.printOrder(orderForm);
        return Result.success();
    }

    /**
     * 未完成
     */
    @ApiOperation("商品回收")
    @ApiImplicitParams({
    })
    @PostMapping("/rollback")
    public Result rollBack(){
        return Result.success();
    }
}
