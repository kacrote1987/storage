package com.storage.mapper;

import com.github.pagehelper.Page;
import com.storage.entity.vo.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopMapper {
    Page<ShopVo> select(Long id,String code);
    GoodsList selectgoods();
    Producer selectproducer();
    Long selectBranchId(Long userId);
    void insertShop(Long branchId,Long goodsId, Long num);
    void updateOrderStatus(Long orderId, Integer status);
    void deleteShop(Long branchId,Long goodsId, Long num);
}
