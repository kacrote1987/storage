package com.storage.mapper;

import com.github.pagehelper.Page;
import com.storage.entity.vo.GoodsList;
import com.storage.entity.vo.Producer;
import com.storage.entity.vo.OrderDetailVo;
import com.storage.entity.vo.OrderVo;
import com.storage.entity.vo.StockVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface StockMapper {
    Page<StockVo> select(String code);
    Page<OrderVo> selectOrder(String orderNo,Long status, Date timeStart, Date timeEnd);
    List<OrderDetailVo> selectOrderDetailById(Long orderId);
    Producer selectproducer();
    GoodsList selectgoods();
    Long selectNum(Long goodsId);
    void insertStock(Long goodsId,Long num);
    void deleteStock(Long goodsId,Long num);
    void uncheckNum(Long goodsId,Long num);
    Long selectUncheckNum(Long orderId,Long goodsId);
    void updateOrderStatus(Long orderId,Integer status);
}
