package com.storage.service.impl;

import com.storage.entity.form.PlanDemandForm;
import com.storage.entity.form.PlanWarningForm;
import com.storage.entity.vo.PlanBranchVo;
import com.storage.entity.vo.PlanVo;
import com.storage.entity.vo.PurchaseVo;
import com.storage.mapper.PlanMapper;
import com.storage.service.PlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Resource
    PlanMapper planMapper;

    @Override
    public List<PlanVo> DemandAnalysis(PlanDemandForm planDemandForm) {
        List<PlanVo> planVoList=planMapper.selectAllBranch();
        for(int i=0;i<planVoList.size();i++){
            //创建planBranchVoList
            List<PlanBranchVo> planBranchVoList=planMapper.selectGoodsList(planVoList.get(i).getBranchId(),planDemandForm.getDateBegin(),planDemandForm.getDateEnd());
            //查询各类商品上一时间段的数量
            //先求时间差
            int datediff = (int) ((planDemandForm.getDateEnd().getTime() - planDemandForm.getDateBegin().getTime()) / (1000*3600*24)) * (-1);
            Calendar cal = Calendar.getInstance();
            cal.setTime(planDemandForm.getDateBegin());
            //再求上个开始日期
            cal.add(Calendar.DAY_OF_MONTH, datediff);
            Date lastDateBegin=cal.getTime();

            List<PlanBranchVo> lastPlanBranchVoList=planMapper.selectGoodsList(planVoList.get(i).getBranchId(),lastDateBegin,planDemandForm.getDateBegin());
            for(int j=0;j<planBranchVoList.size();j++){
                planBranchVoList.get(j).setBranchLastNum(lastPlanBranchVoList.get(j).getBranchNum());
                planBranchVoList.get(j).setIncreaseRate(planBranchVoList.get(j).getBranchNum()/planBranchVoList.get(j).getBranchLastNum()-1);
                planBranchVoList.get(j).setNextNum(planBranchVoList.get(j).getBranchNum()*(1+planBranchVoList.get(j).getIncreaseRate()));
            }
            //查询各类商品在日期区间中的明细。将planBranchVoList放入planVoList中。
            planVoList.get(i).setPlanBranchVoList(planBranchVoList);
        }
        return planVoList;
    }

    @Override
    public void UpdateWarning(List<PlanWarningForm> planWarningFormList) {
        //为使数据保持致，先清空之前的所有预警数
        planMapper.deleteStockNumMin();
        planMapper.deleteShopNumMin();
        for(int i=0;i<planWarningFormList.size();i++){
            if(planWarningFormList.get(i).getBranchId()==2){//将在线商城的预警数加入总库存中
                planMapper.updateStockNumMin(planWarningFormList.get(i).getGoodsId(),planWarningFormList.get(i).getNextNum());
            }else{//更新各门店的库存预警数，并加到总库存中
                planMapper.updateShopNumMin(planWarningFormList.get(i).getBranchId(),planWarningFormList.get(i).getGoodsId(),planWarningFormList.get(i).getNextNum());
                planMapper.updateStockNumMin(planWarningFormList.get(i).getGoodsId(),planWarningFormList.get(i).getNextNum());
            }
        }
    }

    @Override
    public List<PurchaseVo> CreatePurchase() {
        //加入需要采购的部门信息
        List<PurchaseVo> purchaseVoList=planMapper.selectBranch();
        for(int i=0;i<purchaseVoList.size();i++){//生成各门店采购计划
            purchaseVoList.get(i).setGoodsVoList(planMapper.selectPurchaseGoodsList(purchaseVoList.get(i).getBranchId()));
        }
        //生成库存采购计划。
        PurchaseVo purchaseVoStock=null;
        purchaseVoStock.setGoodsVoList(planMapper.createStockPurchase());
        purchaseVoList.add(purchaseVoList.size(),purchaseVoStock);
        return purchaseVoList;
    }

    @Override
    public void CreateReport() {

    }
}
