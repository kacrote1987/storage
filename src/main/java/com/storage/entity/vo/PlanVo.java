package com.storage.entity.vo;

import java.util.List;

public class PlanVo {
    private Long branchId;
    private String branchName;
    private List<PlanBranchVo> planBranchVoList;

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

}
