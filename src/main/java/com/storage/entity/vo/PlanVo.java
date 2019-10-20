package com.storage.entity.vo;

import java.util.List;

public class PlanVo {
    private Long branchId;
    private String branchName;
    private List<PlanBranchVo> planBranchVoList;
    private Long branchCost;
    private Long branchIncome;
    private Long branchProfit;
    private Long increaseRate;
    private Long nextNum;

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public List<PlanBranchVo> getPlanBranchVoList() {
        return planBranchVoList;
    }

    public void setPlanBranchVoList(List<PlanBranchVo> planBranchVoList) {
        this.planBranchVoList = planBranchVoList;
    }

    public Long getBranchCost() {
        return branchCost;
    }

    public void setBranchCost(Long branchCost) {
        this.branchCost = branchCost;
    }

    public Long getBranchIncome() {
        return branchIncome;
    }

    public void setBranchIncome(Long branchIncome) {
        this.branchIncome = branchIncome;
    }

    public Long getBranchProfit() {
        return branchProfit;
    }

    public void setBranchProfit(Long branchProfit) {
        this.branchProfit = branchProfit;
    }

    public Long getIncreaseRate() {
        return increaseRate;
    }

    public void setIncreaseRate(Long increaseRate) {
        this.increaseRate = increaseRate;
    }

    public Long getNextNum() {
        return nextNum;
    }

    public void setNextNum(Long nextNum) {
        this.nextNum = nextNum;
    }
}
