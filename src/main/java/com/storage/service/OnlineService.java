package com.storage.service;

import com.github.pagehelper.Page;
import com.storage.entity.form.CartForm;
import com.storage.entity.form.GoodsForm;
import com.storage.entity.form.LoginForm;
import com.storage.entity.vo.*;

public interface OnlineService {
    /**
     * 客户登陆
     */
    CustomerLoginVo login(LoginForm form);
    /**
     * 商品查询
     */
    Page<GoodsVo> selectGoods(GoodsForm goodsForm);
    /**
     * 加入购物车
     */
    void insertCart(Long customerId,Long goodsId,Long num);
    /**
     * 移除购物车
     */
    void deleteCart(Long customerId,Long goodsId,Long num);
    /**
     * 查询购物车
     */
    CartVo selectCart(Long customerId);
    /**
     * 生成订单
     */
    void createOrder(CartForm cartForm);
    /**
     * 积分更新
     */
    void updateScore(CartForm cartForm);
    /**
     * 个人订单查询
     */
    OrderVo myOrder(Long customerId);
}
