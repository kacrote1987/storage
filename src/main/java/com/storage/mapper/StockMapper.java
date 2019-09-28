package com.storage.mapper;

import com.github.pagehelper.Page;
import com.storage.entity.Producer;
import com.storage.entity.Stock;
import com.storage.entity.vo.OrderVo;
import com.storage.entity.vo.StockVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface StockMapper {
    Page<StockVo> select(String code);
    Page<StockVo> selectId(Long id);
    Page<OrderVo> selectorder(String code, Date timeStart, Date timeEnd);
    OrderVo selectorderbyno(String orderno);
    Producer selectproducer();
    Stock selectstock();
    Long selectnum(Long id);
    void insertorder(String orderno,String operator,String producer,Integer tag);
    void insertorderdetail(Long orderId,Long stockId,Long num);
    void insertstock(Long id,Long num);
    void deletestock(Long id,Long num);
}
