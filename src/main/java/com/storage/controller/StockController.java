package com.storage.controller;

import com.github.pagehelper.Page;
import com.storage.entity.Producer;
import com.storage.entity.Stock;
import com.storage.entity.form.OrderForm;
import com.storage.entity.form.OrderSelectForm;
import com.storage.entity.form.StockForm;
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
import java.util.Date;

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
    public Result select(StockForm stockForm){
        Page<StockVo> list= stockService.select(stockForm);
        return Result.success(list);
    }

    @ApiOperation("入库查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="String", name = "code", value = "商品代码/商品名称（支持模糊查询）", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="Date", name = "timeStart", value = "开始日期", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="Date", name = "timeEnd", value = "结束日期", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="Integer", name = "pageNo", value = "页数", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="Integer", name = "pageSize", value = "每页显示记录数", required = true, dataType = "Form")
    })
    @PostMapping("/selectorder")
    public Result selectorder(OrderSelectForm orderSelectForm){
        Page<OrderVo> list= stockService.selectorder(orderSelectForm);
        return Result.success(list);
    }

    @ApiOperation("商品列表")
    @PostMapping("/stocklist")
    public Result stocklist(){
        Stock stocklist= stockService.stocklist();
        return Result.success(stocklist);
    }

    @ApiOperation("供应商列表")
    @PostMapping("/producerlist")
    public Result producerlist(){
        Producer producerlist= stockService.producerlist();
        return Result.success(producerlist);
    }

    @ApiOperation("生成订单并入库")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="String", name = "operator", value = "操作人", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="String", name = "producer", value = "生产厂商", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="String", name = "orderDetailForms", value = "商品列表", required = true, dataType = "Form")
    })
    @PostMapping("/instock")
    public Result instock(@RequestBody OrderForm orderForm){
        OrderVo orderVo=stockService.instock(orderForm);
        return Result.success(orderVo);
    }

    @ApiOperation("出库并生成出库单")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="String", name = "operator", value = "操作人", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="String", name = "producer", value = "生产厂商", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="List", name = "orderDetailForms", value = "操作人", required = true, dataType = "Form"),
            @ApiImplicitParam(paramType="Long", name = "id", value = "id", required = true, dataType = "View"),
            @ApiImplicitParam(paramType="Date", name = "time", value = "订单时间", required = true, dataType = "View"),
            @ApiImplicitParam(paramType="Long", name = "orderno", value = "订单编号", required = true, dataType = "View"),
            @ApiImplicitParam(paramType="String", name = "operator", value = "操作人", required = true, dataType = "View"),
            @ApiImplicitParam(paramType="String", name = "producer", value = "生产厂商", required = true, dataType = "View"),
            @ApiImplicitParam(paramType="List", name = "orderDetailForms", value = "订单详细", required = true, dataType = "View"),
    })
    @PostMapping("/outstock")
    public Result outstock(@RequestBody OrderForm orderForm){
        OrderVo orderVo=stockService.outstock(orderForm);
        return Result.success(orderVo);
    }
}
