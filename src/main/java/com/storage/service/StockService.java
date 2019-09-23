package com.storage.service;

import com.github.pagehelper.Page;
import com.storage.entity.form.StockForm;

import java.util.List;

public interface StockService {
    /**
     * 库存查询
     */
    Page select(StockForm form);
    /**
     * 手动入库
     */
    String insert(StockForm form);
    /**
     * 出库操作
     */
    String out(List<StockForm> list);
}
