package com.storage.service;

import com.github.pagehelper.Page;
import com.storage.entity.form.OrderForm;
import com.storage.entity.form.OrderSelectForm;
import com.storage.entity.form.ShopSelectForm;
import com.storage.entity.form.StockSelectForm;
import com.storage.entity.vo.*;

public interface ShopService {
    /**
     * 门店库存查询
     */
    Page<ShopVo> select(ShopSelectForm shopSelectForm);
    /**
     * 商品列表
     */
    GoodsList goodslist();
    /**
     * 供应商列表
     */
    Producer producerlist();
    /**
     * 补货
     */
    void supply(OrderForm orderForm);
    /**
     * 零售
     */
    void sale(Long userId,Long goodsId,Long num);
}
