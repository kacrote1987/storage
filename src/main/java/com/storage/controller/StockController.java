package com.storage.controller;

import com.storage.entity.form.StockForm;
import com.storage.entity.vo.StockVo;
import com.storage.service.StockService;
import com.storage.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Resource
    StockService stockService;
    @PostMapping("/select")
    public Result login(@RequestBody StockForm form){
        List<StockVo> list= stockService.select(form);
        return Result.success(list);
    }
    @PostMapping("/insert")
    public Result insert(@RequestBody StockForm form){
        stockService.insert(form);
        return null;
    }
    @PostMapping("/out")
    public Result out(@RequestBody List<StockForm> list){
        stockService.out(list);
        return null;
    }
}
