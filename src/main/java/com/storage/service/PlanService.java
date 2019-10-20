package com.storage.service;

import com.storage.entity.form.PlanDemandForm;
import com.storage.entity.form.PlanWarningForm;
import com.storage.entity.vo.PlanVo;
import com.storage.entity.vo.PurchaseVo;

import java.util.List;

public interface PlanService {
    /**
     * 客户需求分析，计算并展示各类商品的消费记录、同比上个时期销售速度的百分比
     */
    List<PlanVo> DemandAnalysis(PlanDemandForm planDemandForm);
    /**
     * 生成预警线
     */
    void UpdateWarning(List<PlanWarningForm> planWarningFormList);
    /**
     * 生成采购计划
     */
    List<PurchaseVo> CreatePurchase();
    /**
     * 生成报表
     */
    void CreateReport();
}
