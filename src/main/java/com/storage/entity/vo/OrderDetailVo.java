package com.storage.entity.vo;

public class OrderDetailVo {
    private Long id;
    private Long gno;
    private String name;
    private String spec;
    private String unit;
    private Long num;
    private String producer;
    private Long priceSale;
    private Long priceVip;
    private Long unchecknum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGno() {
        return gno;
    }

    public void setGno(Long gno) {
        this.gno = gno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
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

    public Long getUnchecknum() {
        return unchecknum;
    }

    public void setUnchecknum(Long unchecknum) {
        this.unchecknum = unchecknum;
    }
}
