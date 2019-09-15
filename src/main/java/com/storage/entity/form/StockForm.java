package com.storage.entity.form;

public class StockForm {
    private Long id;
    private Long catgId;
    private String name;
    private Long num;
    private String cabno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCatgId() {
        return catgId;
    }

    public void setCatgId(Long catgId) {
        this.catgId = catgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getCabno() {
        return cabno;
    }

    public void setCabno(String cabno) {
        this.cabno = cabno;
    }
}
