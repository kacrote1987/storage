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
    Page<OrderVo> selectorder(String code, Date timeStart, Date timeEnd);
    List<OrderDetailVo> selectOrderDetailById(Long orderId);
    OrderVo selectorderbyno(String orderno);
    Producer selectproducer();
    GoodsList selectgoods();
    Long selectnum(Long goodsId);
    void insertorder(String orderno,Long userId,Integer status);
    void insertorderdetail(Long orderId,Long goodsId,Long num);
    void insertstock(Long goodsId,Long num);
    void deletestock(Long goodsId,Long num);
}
