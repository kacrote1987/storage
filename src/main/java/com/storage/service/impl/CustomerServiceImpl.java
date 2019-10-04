package com.storage.service.impl;

import com.storage.entity.form.CustomerForm;
import com.storage.entity.vo.*;
import com.storage.exception.UnAuthorizationException;
import com.storage.mapper.CustomerMapper;
import com.storage.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    CustomerMapper customerMapper;

    @Override
    public List<CustomerVo> select(String code) {
        List<CustomerVo> list=customerMapper.selectCustomer(code);
        return list;
    }

    @Override
    public Long getcustomerid(String code) {
        Long id=customerMapper.selectcustomerid(code);
        if(id==null){
            throw new UnAuthorizationException("无法获取用户信息");
        }
        return id;
    }

    @Override
    public void register(CustomerForm customerForm) {
        if(customerMapper.selectcustomerid(customerForm.getIdCard().toString())!=null || customerMapper.selectcustomerid(customerForm.getTel().toString())!=null){
            throw new UnAuthorizationException("用户已开户");
        }
        String vipCard= UUID.randomUUID().toString();
        customerMapper.register(customerForm.getName(),customerForm.getIdCard(),customerForm.getTel(),vipCard);
    }

    @Override
    public void unregister(Long id) {
        customerMapper.unregister(id);
    }
}
