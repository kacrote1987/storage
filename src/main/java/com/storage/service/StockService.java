package com.storage.service;

import com.github.pagehelper.Page;
import com.storage.entity.form.OrderForm;
import com.storage.entity.vo.GoodsList;
import com.storage.entity.vo.Producer;
import com.storage.entity.form.OrderSelectForm;
import com.storage.entity.form.StockSelectForm;
import com.storage.entity.vo.OrderVo;
import com.storage.entity.vo.StockVo;

import java.util.List;

public interface StockService {
    /**
     * 库存查询
     */
    Page<StockVo> select(StockSelectForm stockForm);
    /**
     * 订单查询
     */
    Page<OrderVo> selectOrder(OrderSelectForm orderSelectForm);
    /**
     * 商品列表
     */
    GoodsList goodslist();
    /**
     * 供应商列表
     */
    Producer producerlist();
    /**
     * 订单挂起
     */
    void checkhang(OrderForm orderForm);
    /**
     * 入库
     */
    void instock(OrderForm orderForm);
    /**
     * 出库
     */
    void outstock(OrderForm orderForm);
}
