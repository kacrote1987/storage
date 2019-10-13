package com.storage.entity.vo;

import java.util.Date;
import java.util.List;

public class CartVo {
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
