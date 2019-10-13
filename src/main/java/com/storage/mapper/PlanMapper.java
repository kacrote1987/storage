package com.storage.mapper;

import com.github.pagehelper.Page;
import com.storage.entity.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlanMapper {
    CustomerLoginVo selectByUsername(String userName, String passWord);
    Page<GoodsVo> selectGoods(Long dictId, String name, Long vipDiscount);
    String selectone(Long customerId, Long goodsId);
    void insertcart(Long customerId, Long goodsId, Long num);
    void pluscart(Long customerId, Long goodsId, Long num);
    void deletecart(Long customerId, Long goodsId);
    void minuscart(Long customerId, Long goodsId, Long num);
    Long getDiscount(Long customerId);
    CartVo selectcart(Long customerId, Long disCount);
    void createOrder(String orderNo, Long customerId, Integer customerType, Integer point, Integer status);
    Long getOrderId(String orderNo);
    void createOrderDetail(Long orderId, Long goodsId, Long num);
    OrderVo selectMyorder(Long customerId);
    List<OrderDetailVo> selectMyorderDetail(Long orderId);
    void updatescore(Long customerId, Long goodsId, Long num);
    void updatevip(Long customerId);
}
