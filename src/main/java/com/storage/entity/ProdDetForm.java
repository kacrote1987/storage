package com.storage.entity;

public class ProdDetForm {
    private Long prodId;
    private String prodType;
    private String prodName;
    private String prodNikname;
    private String prodVer;
    private String prodExplain;

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

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

    public String getProdNikname() {
        return prodNikname;
    }

    public void setProdNikname(String prodNikname) {
        this.prodNikname = prodNikname;
    }

    public String getProdVer() {
        return prodVer;
    }

    public void setProdVer(String prodVer) {
        this.prodVer = prodVer;
    }

    public String getProdExplain() {
        return prodExplain;
    }

    public void setProdExplain(String prodExplain) {
        this.prodExplain = prodExplain;
    }
}
