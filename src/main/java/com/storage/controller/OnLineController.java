package com.storage.controller;

import com.github.pagehelper.Page;
import com.storage.entity.form.CartForm;
import com.storage.entity.form.GoodsForm;
import com.storage.entity.form.LoginForm;
import com.storage.entity.vo.CartVo;
import com.storage.entity.vo.CustomerLoginVo;
import com.storage.entity.vo.GoodsVo;
import com.storage.entity.vo.OrderVo;
import com.storage.service.OnlineService;
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
import javax.validation.Valid;

@Api(description = "在线商城")
@RestController
@RequestMapping("/online")
public class OnLineController {
    @Resource
    OnlineService onlineService;


    @ApiOperation("登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "password", value = "密码", required = true, dataType = "String")
    })
    @PostMapping("/login")
    public Result login(@RequestBody @Valid LoginForm form){
        CustomerLoginVo customerLoginVo=onlineService.login(form);
        return Result.success(customerLoginVo);
    }

    @ApiOperation("商品查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="Integer", name = "dictId", value = "商品类别（选择框）", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="String", name = "name", value = "商品名称（支持模糊查询）", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="Integer", name = "vipDiscount", value = "VIP打折率", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="Integer", name = "pageNo", value = "页数", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="Integer", name = "pageSize", value = "每页显示记录数", required = true, dataType = "Form")
    })
    @PostMapping("/selectgoods")
    public Result selectGoods(@RequestBody GoodsForm goodsForm){
        Page<GoodsVo> list= onlineService.selectGoods(goodsForm);
        return Result.success(list);
    }

    @ApiOperation("加入购物车")
    @PostMapping("/insertcart")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="Integer", name = "customerId", value = "客户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="Integer", name = "goodsId", value = "商品ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="Integer", name = "num", value = "商品数量", required = true, dataType = "Integer")
    })
    public Result insertCart(Long customerId,Long goodsId,Long num){
        onlineService.insertCart(customerId,goodsId,num);
        return Result.success();
    }

    @ApiOperation("移除购物车")
    @PostMapping("/deletecart")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="Integer", name = "customerId", value = "客户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="Integer", name = "goodsId", value = "商品ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="Integer", name = "num", value = "商品数量", required = true, dataType = "Integer")
    })
    public Result deleteCart(Long customerId,Long goodsId,Long num){
        onlineService.deleteCart(customerId,goodsId,num);
        return Result.success();
    }

    @ApiOperation("查询购物车")
    @PostMapping("/selectcart")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="Integer", name = "customerId", value = "客户ID", required = true, dataType = "Integer")
    })
    public Result selectCart(Long customerId){
        CartVo cartVo= onlineService.selectCart(customerId);
        return Result.success(cartVo);
    }

    @ApiOperation("支付并生成订单（出库单）")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="List", name = "cartForm", value = "购物车商品列表", required = true, dataType = "Form")
    })
    @PostMapping("/createorder")
    public Result instock(@RequestBody CartForm cartForm){
        /**
         * 省略支付步骤
         */
        onlineService.createOrder(cartForm);//创建订单
        onlineService.updateScore(cartForm);//积分更新
        return Result.success();
    }

    @ApiOperation("个人订单（出库单）查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="Integer", name = "customerId", value = "客户ID", required = true, dataType = "Integer")
    })
    @PostMapping("/myorder")
    public Result myOrder(Long customerId){
        OrderVo orderVo=onlineService.myOrder(customerId);
        return Result.success(orderVo);
    }
}
