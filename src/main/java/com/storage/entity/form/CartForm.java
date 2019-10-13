package com.storage.entity.form;

import com.storage.entity.vo.GoodsVo;

import java.util.List;

public class CartForm {
    private Long customerId;
    private List<GoodsVo> list;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<GoodsVo> getList() {
        return list;
    }

    public void setList(List<GoodsVo> list) {
        this.list = list;
    }
}
