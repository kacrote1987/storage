package com.storage.entity.form;

public class StockForm {
    private Long id;
    private Long catgId;
    private String name;
    private Long num;
    private String cabno;
    private Integer pageNo;
    private Integer size;

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

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
