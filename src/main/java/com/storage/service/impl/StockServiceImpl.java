package com.storage.service.impl;

import com.storage.entity.form.StockForm;
import com.storage.entity.vo.StockVo;
import com.storage.mapper.StockMapper;
import com.storage.service.StockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    @Resource
    StockMapper stockMapper;

    @Override
    public List select(StockForm form) {
        List<StockVo> list=stockMapper.select(form.getCatgId(),form.getName(),form.getNum(),form.getCabno());
        return list;
    }

    @Override
    public String insert(StockForm form) {
        stockMapper.insert(form.getCatgId(),form.getName(),form.getNum(),form.getCabno());
        return "入库成功";
    }

    @Override
    public String out(List<StockForm> list) {
        for(int i=0;i<list.size();i++){
            stockMapper.out(list.get(i).getId(),list.get(i).getNum());
        }
        return "出库成功";
    }
}
