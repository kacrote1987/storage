package com.storage.mapper;

import com.storage.entity.vo.PlanBranchVo;
import com.storage.entity.vo.PlanVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface PlanMapper {
    List<PlanVo> selectBranchId();
    List<PlanBranchVo> selectGoodsList(Long branchId, Date dateBegin, Date dateEnd);
    Long selectBranchCost(Long branchId,Date dateBegin, Date dateEnd);
    Long selectBranchIncome(Long branchId,Date dateBegin, Date dateEnd);
    Long selectBranchProfit(Long branchId,Date dateBegin, Date dateEnd);
    Long getIncreaseRate(Long branchId,Date dateBegin, Date dateEnd);
    Long getNextNum(Long branchId,Date dateBegin, Date dateEnd,Long increaseRate);
    void updateStockNumMin(Long goodsId,Long numMin);
    void updateShopNumMin(Long branchId,Long Integer,Long numMin);
}
