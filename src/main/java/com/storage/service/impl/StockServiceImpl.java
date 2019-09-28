package com.storage.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.storage.entity.Producer;
import com.storage.entity.Stock;
import com.storage.entity.form.OrderForm;
import com.storage.entity.form.OrderSelectForm;
import com.storage.entity.form.StockForm;
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
    public Page<StockVo> select(StockForm stockForm) {
        PageHelper.startPage(stockForm.getPageNo(),stockForm.getPageSize());
        Page<StockVo> list=stockMapper.select(stockForm.getCode());
        return list;
    }

    @Override
    public Page<OrderVo> selectorder(OrderSelectForm orderSelectForm) {
        PageHelper.startPage(orderSelectForm.getPageNo(),orderSelectForm.getPageSize());
        Page<OrderVo> orderVoPage=stockMapper.selectorder(orderSelectForm.getCode(),orderSelectForm.getTimeStart(),orderSelectForm.getTimeEnd());
        for(int i=0;i<orderVoPage.size();i++){
            orderVoPage.get(i).setList(stockMapper.selectId(orderVoPage.get(i).getId()));
        }
        return orderVoPage;
    }

    @Override
    public Stock stocklist() {
        Stock stock=stockMapper.selectstock();
        return stock;
    }

    @Override
    public Producer producerlist() {
        Producer producer=stockMapper.selectproducer();
        return producer;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderVo instock(OrderForm orderForm) {
        String orderno=UUID.randomUUID().toString();
        stockMapper.insertorder(orderno,orderForm.getOperator(),orderForm.getProducer(),1);
        OrderVo orderVo=stockMapper.selectorderbyno(orderno);
        for(int i=0;i<orderForm.getOrderDetailForms().size();i++){
            stockMapper.insertorderdetail(orderVo.getList().get(i).getId(),orderForm.getOrderDetailForms().get(i).getId(),orderForm.getOrderDetailForms().get(i).getNum());
            stockMapper.insertstock(orderForm.getOrderDetailForms().get(i).getId(),orderForm.getOrderDetailForms().get(i).getNum());
        }
        return orderVo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderVo outstock(OrderForm orderForm) {
        //先判断是否超库存量
        for(int j=0;j<orderForm.getOrderDetailForms().size();j++){
            if(orderForm.getOrderDetailForms().get(j).getNum()>stockMapper.selectnum(orderForm.getOrderDetailForms().get(j).getId()))
            throw new RuntimeException("库存不足");
        }
        //再执行出库操作
        String orderno=UUID.randomUUID().toString();
        stockMapper.insertorder(orderno,orderForm.getOperator(),orderForm.getProducer(),-1);
        OrderVo orderVo=stockMapper.selectorderbyno(orderno);
        for(int i=0;i<orderForm.getOrderDetailForms().size();i++){
            stockMapper.insertorderdetail(orderVo.getList().get(i).getId(),orderForm.getOrderDetailForms().get(i).getId(),orderForm.getOrderDetailForms().get(i).getNum());
            stockMapper.deletestock(orderForm.getOrderDetailForms().get(i).getId(),orderForm.getOrderDetailForms().get(i).getNum());
        }
        return orderVo;
    }
}
