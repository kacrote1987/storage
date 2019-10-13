package com.storage.entity.vo;

import java.util.Date;
import java.util.List;

public class OrderVo {
    private Long id;
    private Date time;
    private Long orderNo;
    private String userName;
    private Long point;
    private Long status;
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

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public List<OrderDetailVo> getList() {
        return list;
    }

    public void setList(List<OrderDetailVo> list) {
        this.list = list;
    }
}
