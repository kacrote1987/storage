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
     * 扫描会员卡获取会员信息
     */
    CustomerVo scanCard(String vipCard);
    /**
     * 扫描商品生成订单
     */
    OrderVo createOrder(OrderForm orderForm);
    /**
     * 取消订单
     */
    void cancel(Long orderId);
    /**
     * 订单结算
     */
    void sale(OrderForm orderForm);
    /**
     * 订单打印
     */
    void printOrder(OrderForm orderForm);
    /**
     * 商品回收
     */
    void rollBack(OrderForm orderForm);
}
