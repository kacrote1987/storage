package com.storage.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.storage.entity.vo.GoodsList;
import com.storage.entity.vo.Producer;
import com.storage.entity.form.OrderForm;
import com.storage.entity.form.OrderSelectForm;
import com.storage.entity.form.StockSelectForm;
import com.storage.entity.vo.OrderVo;
import com.storage.entity.vo.StockVo;
import com.storage.mapper.StockMapper;
import com.storage.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class StockServiceImpl implements StockService {
    @Resource
    StockMapper stockMapper;

    @Override
    public Page<StockVo> select(StockSelectForm stockSelectForm) {
        PageHelper.startPage(stockSelectForm.getPageNo(),stockSelectForm.getPageSize());
        Page<StockVo> list=stockMapper.select(stockSelectForm.getCode());
        return list;
    }

    @Override
    public Page<OrderVo> selectorder(OrderSelectForm orderSelectForm) {
        PageHelper.startPage(orderSelectForm.getPageNo(),orderSelectForm.getPageSize());
        Page<OrderVo> orderVoPage=stockMapper.selectorder(orderSelectForm.getCode(),orderSelectForm.getTimeStart(),orderSelectForm.getTimeEnd());
        for(int i=0;i<orderVoPage.size();i++){
            orderVoPage.get(i).setList(stockMapper.selectOrderDetailById(orderVoPage.get(i).getId()));
        }
        return orderVoPage;
    }

    @Override
    public GoodsList goodslist() {
        GoodsList goodsList=stockMapper.selectgoods();
        return goodsList;
    }

    @Override
    public Producer producerlist() {
        Producer producerlist=stockMapper.selectproducer();
        return producerlist;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderVo instock(OrderForm orderForm) {
        String orderno=UUID.randomUUID().toString();
        stockMapper.insertorder(orderno,orderForm.getUserId(),1);
        OrderVo orderVo=stockMapper.selectorderbyno(orderno);
        for(int i=0;i<orderForm.getOrderDetailForms().size();i++){
            stockMapper.insertorderdetail(orderVo.getId(),orderForm.getOrderDetailForms().get(i).getGoodsId(),orderForm.getOrderDetailForms().get(i).getNum());
            stockMapper.insertstock(orderForm.getOrderDetailForms().get(i).getGoodsId(),orderForm.getOrderDetailForms().get(i).getNum());
        }
        return orderVo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderVo outstock(OrderForm orderForm) {
        //先判断是否超库存量
        for(int i=0;i<orderForm.getOrderDetailForms().size();i++){
            if(orderForm.getOrderDetailForms().get(i).getNum()>stockMapper.selectnum(orderForm.getOrderDetailForms().get(i).getGoodsId()))
            throw new RuntimeException("库存不足");
        }
        //再执行出库操作
        String orderno=UUID.randomUUID().toString();
        stockMapper.insertorder(orderno,orderForm.getUserId(),-1);
        OrderVo orderVo=stockMapper.selectorderbyno(orderno);
        for(int j=0;j<orderForm.getOrderDetailForms().size();j++){
            stockMapper.insertorderdetail(orderVo.getId(),orderForm.getOrderDetailForms().get(j).getGoodsId(),orderForm.getOrderDetailForms().get(j).getNum());
            stockMapper.deletestock(orderForm.getOrderDetailForms().get(j).getGoodsId(),orderForm.getOrderDetailForms().get(j).getNum());
        }
        return orderVo;
    }
}
