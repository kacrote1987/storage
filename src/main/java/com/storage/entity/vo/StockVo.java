package com.storage.entity.vo;

public class StockVo {
    private String name;
    private Integer num;
    private String cabno;
    private Long catgId;
    private String catgName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCabno() {
        return cabno;
    }

    public void setCabno(String cabno) {
        this.cabno = cabno;
    }

    public Long getCatgId() {
        return catgId;
    }

    public void setCatgId(Long catgId) {
        this.catgId = catgId;
    }

    public String getCatgName() {
        return catgName;
    }

    public void setCatgName(String catgName) {
        this.catgName = catgName;
    }
}
