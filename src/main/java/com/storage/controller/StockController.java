package com.storage.controller;

import com.github.pagehelper.Page;
import com.storage.entity.form.StockSelectForm;
import com.storage.entity.vo.GoodsList;
import com.storage.entity.vo.Producer;
import com.storage.entity.form.OrderForm;
import com.storage.entity.form.OrderSelectForm;
import com.storage.entity.vo.OrderVo;
import com.storage.entity.vo.StockVo;
import com.storage.service.StockService;
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

@Api(description = "库存管理")
@RestController
@RequestMapping("/stock")
public class StockController {
    @Resource
    StockService stockService;

    @ApiOperation("库存查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="String", name = "code", value = "商品代码/商品名称（支持模糊查询）", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="Integer", name = "pageNo", value = "页数", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="Integer", name = "pageSize", value = "每页显示记录数", required = true, dataType = "Form")
    })
    @PostMapping("/select")
    public Result select(@RequestBody StockSelectForm stockSelectForm){
        Page<StockVo> list= stockService.select(stockSelectForm);
        return Result.success(list);
    }

    @ApiOperation("订单查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="String", name = "orderNo", value = "订单编号", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="Integer", name = "status", value = "订单状态", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="Date", name = "timeStart", value = "开始日期", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="Date", name = "timeEnd", value = "结束日期", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="Integer", name = "pageNo", value = "页数", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="Integer", name = "pageSize", value = "每页显示记录数", required = true, dataType = "Form")
    })
    @PostMapping("/selectorder")
    public Result selectorder(@RequestBody OrderSelectForm orderSelectForm){
        Page<OrderVo> list= stockService.selectOrder(orderSelectForm);
        return Result.success(list);
    }

    @ApiOperation("商品列表")
    @PostMapping("/goodslist")
    public Result goodslist(){
        GoodsList goodslist= stockService.goodslist();
        return Result.success(goodslist);
    }

    @ApiOperation("供应商列表")
    @PostMapping("/producerlist")
    public Result producerlist(){
        Producer producerlist= stockService.producerlist();
        return Result.success(producerlist);
    }

    /**
     * 当入库时发现订单中商品数量或质量出现问题时，可以将没有问题的商品正常入库，有问题的商品进行标记暂不入库，并将该订单挂起，待全部合格则全部入库取消挂起。
     * @param
     * @return
     */
    @ApiOperation("订单挂起")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="List", name = "orderForm", value = "订单（提交订单中可以入库的商品）", required = true, dataType = "Form")
    })
    @PostMapping("/checkhang")
    public Result checkhang(@RequestBody OrderForm orderForm){
        stockService.checkhang(orderForm);
        return Result.success();
    }

    @ApiOperation("入库")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="List", name = "orderForm", value = "订单", required = true, dataType = "Form")
    })
    @PostMapping("/instock")
    public Result instock(OrderForm orderForm){
        stockService.instock(orderForm);
        return Result.success();
    }

    @ApiOperation("出库")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="List", name = "orderForm", value = "订单", required = true, dataType = "Form")
    })
    @PostMapping("/outstock")
    public Result outstock(OrderForm orderForm){
        stockService.outstock(orderForm);
        return Result.success();
    }

    /**
     * 以下未完成
     * @param
     * @return
     */
    @ApiOperation("库存预警")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="List", name = "planForm", value = "采购计划指标", required = true, dataType = "Form")
    })
    @PostMapping("/warning")
    public Result warning(){
        return Result.success();
    }

    @ApiOperation("获取采购单")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="List", name = "planForm", value = "采购计划指标", required = true, dataType = "Form")
    })
    @PostMapping("/selectpurchase")
    public Result selectpurchase(){
        return Result.success();
    }
}
