package com.storage.entity.vo;

import java.util.Date;
import java.util.List;

public class GoodsVo {
    private Long id;
    private String dictName;
    private Long gno;
    private String name;
    private String spec;
    private String projName;
    private String unit;
    private Long priceSale;
    private Long priceVip;
    private Long num;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
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

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}
