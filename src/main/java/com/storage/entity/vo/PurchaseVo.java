package com.storage.entity.vo;

import java.util.List;

public class PurchaseVo {
    private Long branchId;
    private String branchName;
    private List<GoodsVo> goodsVoList;

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

    public List<GoodsVo> getGoodsVoList() {
        return goodsVoList;
    }

    public void setGoodsVoList(List<GoodsVo> goodsVoList) {
        this.goodsVoList = goodsVoList;
    }
}
