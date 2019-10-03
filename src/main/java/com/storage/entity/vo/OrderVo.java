package com.storage.entity.vo;

import java.util.Date;
import java.util.List;

public class OrderVo {
    private Long id;
    private Date time;
    private Long orderno;
    private String userName;
    List<OrderDetailVo> list;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<OrderDetailVo> getList() {
        return list;
    }

    public void setList(List<OrderDetailVo> list) {
        this.list = list;
    }
}
