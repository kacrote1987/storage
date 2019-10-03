package com.storage.entity.form;

import java.util.List;

public class OrderForm {
    private Long userId;
    private List<OrderDetailForm> orderDetailForms;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<OrderDetailForm> getOrderDetailForms() {
        return orderDetailForms;
    }

    public void setOrderDetailForms(List<OrderDetailForm> orderDetailForms) {
        this.orderDetailForms = orderDetailForms;
    }
}
