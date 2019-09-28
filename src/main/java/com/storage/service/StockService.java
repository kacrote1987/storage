package com.storage.service;

import com.github.pagehelper.Page;
import com.storage.entity.Producer;
import com.storage.entity.Stock;
import com.storage.entity.form.OrderDetailForm;
import com.storage.entity.form.OrderForm;
import com.storage.entity.form.OrderSelectForm;
import com.storage.entity.form.StockForm;
import com.storage.entity.vo.OrderVo;
import com.storage.entity.vo.StockVo;

import java.util.Date;

public interface StockService {
    /**
     * 库存查询
     */
    Page<StockVo> select(StockForm stockForm);
    /**
     * 入库查询
     */
    Page<OrderVo> selectorder(OrderSelectForm orderSelectForm);
    /**
     * 商品列表
     */
    Stock stocklist();
    /**
     * 供应商列表
     */
    Producer producerlist();
    /**
     * 生成订单并入库
     */
    OrderVo instock(OrderForm orderForm);
    /**
     * 出库并生成出库单
     */
    OrderVo outstock(OrderForm orderForm);
}
