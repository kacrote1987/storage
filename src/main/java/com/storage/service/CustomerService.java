package com.storage.service;

import com.storage.entity.form.CustomerForm;
import com.storage.entity.vo.*;

import java.util.List;

public interface CustomerService {
    /**
     * 客户查询
     */
    List<CustomerVo> select(String code);
    /**
     * 获取当前用户
     */
    Long getcustomerid(String code);
    /**
     * 开户
     */
    void register(CustomerForm customerForm);
    /**
     * 注销
     */
    void unregister(Long id);
}
