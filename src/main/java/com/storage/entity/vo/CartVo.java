package com.storage.entity.vo;

import java.util.List;

public class CartVo {
    private Long customerId;
    private List<GoodsVo> list;
    private Long priceSale;
    private Long priceVip;

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

    public Long getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(Long priceSale) {
        this.priceSale = priceSale;
    }

    public Long getPriceVip() {
        return priceVip;
    }

    public void setPriceVip(Long priceVip) {
        this.priceVip = priceVip;
    }
}
