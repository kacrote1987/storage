package com.storage.entity.vo;

public class PlanBranchVo {
    private Long goodsId;
    private String goodsName;
    private Long branchNum;
    private String unit;
    private Long branchCost;
    private Long branchIncome;
    private Long branchProfit;

    private Long branchLastNum;
    private Long increaseRate;
    private Long nextNum;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getBranchNum() {
        return branchNum;
    }

    public void setBranchNum(Long branchNum) {
        this.branchNum = branchNum;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public Long getBranchLastNum() {
        return branchLastNum;
    }

    public void setBranchLastNum(Long branchLastNum) {
        this.branchLastNum = branchLastNum;
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
