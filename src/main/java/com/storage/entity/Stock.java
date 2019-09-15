package com.storage.entity;

public class Stock {
    private Integer id;
    private Integer catgId;
    private String name;
    private Integer num;
    private String cabno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCatgId() {
        return catgId;
    }

    public void setCatgId(Integer catgId) {
        this.catgId = catgId;
    }

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
}
