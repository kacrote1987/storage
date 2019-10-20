package com.storage.entity.vo;

public class PlanBranchVo {
    private Long goodsId;
    private String goodsName;
    private Long totalNum;
    private String unit;
    private  Long totalCost;
    private Long totalIncome;
    private Long branchProfit;

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

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Long totalCost) {
        this.totalCost = totalCost;
    }

    public Long getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Long totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Long getBranchProfit() {
        return branchProfit;
    }

    public void setBranchProfit(Long branchProfit) {
        this.branchProfit = branchProfit;
    }
}
