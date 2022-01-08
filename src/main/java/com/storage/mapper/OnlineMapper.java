package com.storage.mapper;

import com.github.pagehelper.Page;
import com.storage.entity.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OnlineMapper {
    CustomerLoginVo selectByUsername(String userName,String passWord);
    Page<GoodsVo> selectGoods(Long dictId,String name,Long vipDiscount);
    String selectOne(Long customerId,Long goodsId);
    void insertCart(Long customerId,Long goodsId,Long num);
    void plusCart(Long customerId,Long goodsId,Long num);
    void deleteCart(Long customerId,Long goodsId);
    void minusCart(Long customerId,Long goodsId,Long num);
    Long getDiscount(Long customerId);
    CartVo selectCart(Long customerId,Long disCount);
    void createOrder(String orderNo,Long customerId,Integer customerType,Integer point,Integer status);
    Long getOrderId(String orderNo);
    void createOrderDetail(Long orderId,Long goodsId,Long num);
    void updatePrice(Long orderId);
    OrderVo selectMyorder(Long customerId);
    List<OrderDetailVo> selectMyorderDetail(Long orderId);
    void updateScore(Long customerId,Long goodsId,Long num);
    void updateVip(Long customerId);
}
