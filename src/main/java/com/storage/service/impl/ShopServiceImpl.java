package com.storage.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.storage.entity.form.OrderForm;
import com.storage.entity.form.ShopSelectForm;
import com.storage.entity.vo.*;
import com.storage.mapper.ShopMapper;
import com.storage.service.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

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
    public CustomerVo scanCard(String vipCard) {
        CustomerVo customerVo=shopMapper.selectCustomerByCard(vipCard);
        return customerVo;
    }

    @Override
    public OrderVo createOrder(OrderForm orderForm) {
        String orderNo=UUID.randomUUID().toString();
        //创建订单
        shopMapper.insertOrder(orderNo,orderForm.getUserId(),2,-2,0);
        Long orderId=shopMapper.selectOrderIdByNo(orderNo);
        //创建订单明细
        for(int i=0;i<orderForm.getOrderDetailForms().size();i++){
            shopMapper.insertOrderDetail(orderId,orderForm.getOrderDetailForms().get(i).getGoodsId(),orderForm.getOrderDetailForms().get(i).getNum());
        }
        //查询订单
        OrderVo orderVo=shopMapper.selectOrder(orderNo);
        orderVo.setList(shopMapper.selectOrderDetail(orderVo.getId()));
        return orderVo;
    }

    @Override
    public void cancel(Long orderId) {
        //取消直接删除订单及明细
        shopMapper.deleteOrderDetail(orderId);
        shopMapper.deleteOrder(orderId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sale(OrderForm orderForm) {
        /**
         * 此处省略支付操作
         */
        for(int i=0;i<orderForm.getOrderDetailForms().size();i++){
            //门店库存更新
            shopMapper.deleteShop(shopMapper.selectBranchId(orderForm.getUserId()),orderForm.getOrderDetailForms().get(i).getGoodsId(),orderForm.getOrderDetailForms().get(i).getNum());
            //用户积分更新
            shopMapper.updatescore(orderForm.getUserId(),orderForm.getOrderDetailForms().get(i).getGoodsId(),orderForm.getOrderDetailForms().get(i).getNum());
        }
        //用户VIP等级更新
        shopMapper.updatevip(orderForm.getUserId());
    }

    @Override
    public void printOrder(OrderForm orderForm) {

    }

    @Override
    public void rollBack(OrderForm orderForm) {

    }
}
