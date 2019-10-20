package com.storage.entity.form;

public class PlanWarningForm {
    private Long branchId;
    private Long goodsId;
    private Long saleNum;
    private Long increaseRate;

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Long saleNum) {
        this.saleNum = saleNum;
    }

    public Long getIncreaseRate() {
        return increaseRate;
    }

    public void setIncreaseRate(Long increaseRate) {
        this.increaseRate = increaseRate;
    }
}
