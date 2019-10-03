package com.storage.service;

import com.github.pagehelper.Page;
import com.storage.entity.vo.GoodsList;
import com.storage.entity.vo.Producer;
import com.storage.entity.form.OrderForm;
import com.storage.entity.form.OrderSelectForm;
import com.storage.entity.form.StockSelectForm;
import com.storage.entity.vo.OrderVo;
import com.storage.entity.vo.StockVo;

public interface StockService {
    /**
     * 库存查询
     */
    Page<StockVo> select(StockSelectForm stockForm);
    /**
     * 入库查询
     */
    Page<OrderVo> selectorder(OrderSelectForm orderSelectForm);
    /**
     * 商品列表
     */
    GoodsList goodslist();
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
