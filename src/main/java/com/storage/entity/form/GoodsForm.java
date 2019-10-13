package com.storage.entity.form;

public class GoodsForm {
    private Long dictId;
    private String name;
    private Long vipDiscount;
    private Integer pageNo;
    private Integer pageSize;

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVipDiscount() {
        return vipDiscount;
    }

    public void setVipDiscount(Long vipDiscount) {
        this.vipDiscount = vipDiscount;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
