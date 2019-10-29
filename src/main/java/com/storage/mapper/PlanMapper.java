package com.storage.mapper;

import com.storage.entity.vo.GoodsVo;
import com.storage.entity.vo.PlanBranchVo;
import com.storage.entity.vo.PlanVo;
import com.storage.entity.vo.PurchaseVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface PlanMapper {
    List<PlanVo> selectPlanBranch();
    List<PlanBranchVo> selectGoodsList(Long branchId, Date dateBegin, Date dateEnd);
    void deleteStockNumMin();
    void deleteShopNumMin();
    void updateStockNumMin(Long goodsId,Long numMin);
    void updateShopNumMin(Long branchId,Long goodsId,Long numMin);
    List<PurchaseVo> selectPurchaseBranch();
    List<GoodsVo> selectPurchaseGoodsList(Long branchId);
    List<GoodsVo> createStockPurchase();
}
