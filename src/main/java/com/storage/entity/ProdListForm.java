package com.storage.entity;

public class ProdListForm {
    private String prodType;
    private String prodName;
    private String prodNickname;
    private String prodState;
    private Integer page;
    private Integer limit;

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdNickname() {
        return prodNickname;
    }

    public void setProdNickname(String prodNickname) {
        this.prodNickname = prodNickname;
    }

    public String getProdState() {
        return prodState;
    }

    public void setProdState(String prodState) {
        this.prodState = prodState;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
