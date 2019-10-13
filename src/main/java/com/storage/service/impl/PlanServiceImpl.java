package com.storage.service.impl;

import com.storage.mapper.PlanMapper;
import com.storage.service.PlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PlanServiceImpl implements PlanService {
    @Resource
    PlanMapper planMapper;

    @Override
    public void createpurchase() {

    }
}
