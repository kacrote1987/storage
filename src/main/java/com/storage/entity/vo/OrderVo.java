package com.storage.entity.vo;

import java.util.Date;
import java.util.List;

public class OrderVo {
    private Long id;
    private Date time;
    private Long orderno;
    private String operator;
    private String producer;
    List<StockVo> list;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getOrderno() {
        return orderno;
    }

    public void setOrderno(Long orderno) {
        this.orderno = orderno;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public List<StockVo> getList() {
        return list;
    }

    public void setList(List<StockVo> list) {
        this.list = list;
    }
}
