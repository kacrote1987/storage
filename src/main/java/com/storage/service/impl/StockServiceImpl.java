package com.storage.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.storage.entity.form.OrderForm;
import com.storage.entity.vo.GoodsList;
import com.storage.entity.vo.Producer;
import com.storage.entity.form.OrderSelectForm;
import com.storage.entity.form.StockSelectForm;
import com.storage.entity.vo.OrderVo;
import com.storage.entity.vo.StockVo;
import com.storage.mapper.StockMapper;
import com.storage.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
    public Page<OrderVo> selectOrder(OrderSelectForm orderSelectForm) {
        PageHelper.startPage(orderSelectForm.getPageNo(),orderSelectForm.getPageSize());
        Page<OrderVo> orderVoPage=stockMapper.selectOrder(orderSelectForm.getOrderNo(),orderSelectForm.getStatus(),orderSelectForm.getTimeStart(),orderSelectForm.getTimeEnd());
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
    public void checkhang(OrderForm orderForm) {
        int checkstatus=0;
        for(int i=0;i<orderForm.getOrderDetailForms().size();i++){
            if(orderForm.getOrderDetailForms().get(i).getNum()<stockMapper.selectUncheckNum(orderForm.getOrderId(),orderForm.getOrderDetailForms().get(i).getGoodsId())){checkstatus++;}
            //将可以入库的商品入库
            stockMapper.insertStock(orderForm.getOrderDetailForms().get(i).getGoodsId(),orderForm.getOrderDetailForms().get(i).getNum());
            //标记未入库的商品数量
            stockMapper.uncheckNum(orderForm.getOrderDetailForms().get(i).getGoodsId(),orderForm.getOrderDetailForms().get(i).getNum());
        }
        if(checkstatus>0){
            stockMapper.updateOrderStatus(orderForm.getOrderId(),2);
        }else{
            stockMapper.updateOrderStatus(orderForm.getOrderId(),0);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void instock(OrderForm orderForm) {
        for(int i=0;i<orderForm.getOrderDetailForms().size();i++){
            stockMapper.insertStock(orderForm.getOrderDetailForms().get(i).getGoodsId(),orderForm.getOrderDetailForms().get(i).getNum());
        }
        stockMapper.updateOrderStatus(orderForm.getOrderId(),0);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void outstock(OrderForm orderForm) {
        //先判断是否超库存量
        for(int i=0;i<orderForm.getOrderDetailForms().size();i++){
            if(orderForm.getOrderDetailForms().get(i).getNum()>stockMapper.selectNum(orderForm.getOrderDetailForms().get(i).getGoodsId()))
            throw new RuntimeException("库存不足");
        }
        //再执行出库操作
        for(int j=0;j<orderForm.getOrderDetailForms().size();j++){
            stockMapper.deleteStock(orderForm.getOrderDetailForms().get(j).getGoodsId(),orderForm.getOrderDetailForms().get(j).getNum());
        }
        stockMapper.updateOrderStatus(orderForm.getOrderId(),-1);
    }
}
