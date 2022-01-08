package com.storage.mapper;

import com.github.pagehelper.Page;
import com.storage.entity.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper {
    Page<ShopVo> select(Long id,String code);
    GoodsList selectgoods();
    Producer selectproducer();
    Long selectBranchId(Long userId);
    void insertShop(Long branchId,Long goodsId, Long num);
    void updateOrderStatus(Long orderId, Integer status);
    CustomerVo selectCustomerByCard(String vipCard);
    void insertOrder(String orderNo,Long userId,Integer userType,Integer point,Integer status);
    Long selectOrderIdByNo(String orderNo);
    void insertOrderDetail(Long orderId,Long goodsId,Long num);
    OrderVo selectOrder(String orderNo);
    List<OrderDetailVo> selectOrderDetail(Long orderId);
    void deleteOrderDetail(Long orderId);
    void deleteOrder(Long orderId);
    void deleteShop(Long branchId,Long goodsId, Long num);
    void updatescore(Long customerId,Long goodsId, Long num);
    void updatevip(Long customerId);
}
