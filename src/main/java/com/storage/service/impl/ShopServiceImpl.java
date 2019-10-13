package com.storage.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.storage.entity.form.OrderForm;
import com.storage.entity.form.OrderSelectForm;
import com.storage.entity.form.ShopSelectForm;
import com.storage.entity.form.StockSelectForm;
import com.storage.entity.vo.*;
import com.storage.mapper.ShopMapper;
import com.storage.mapper.StockMapper;
import com.storage.service.ShopService;
import com.storage.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ShopServiceImpl implements ShopService {
    @Resource
    ShopMapper shopMapper;

    @Override
    public Page<ShopVo> select(ShopSelectForm shopSelectForm) {
        PageHelper.startPage(shopSelectForm.getPageNo(),shopSelectForm.getPageSize());
        Page<ShopVo> list=shopMapper.select(shopSelectForm.getId(),shopSelectForm.getCode());
        return list;
    }

    @Override
    public GoodsList goodslist() {
        GoodsList goodsList=shopMapper.selectgoods();
        return goodsList;
    }

    @Override
    public Producer producerlist() {
        Producer producerlist=shopMapper.selectproducer();
        return producerlist;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void supply(OrderForm orderForm) {
        for(int i=0;i<orderForm.getOrderDetailForms().size();i++){
            shopMapper.insertShop(shopMapper.selectBranchId(orderForm.getUserId()),orderForm.getOrderDetailForms().get(i).getGoodsId(),orderForm.getOrderDetailForms().get(i).getNum());
        }
        shopMapper.updateOrderStatus(orderForm.getOrderId(),0);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sale(Long userId,Long goodsId,Long num) {
        shopMapper.deleteShop(shopMapper.selectBranchId(userId),goodsId,num);
    }
}
