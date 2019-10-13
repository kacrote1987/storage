package com.storage.controller;

import com.storage.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(description = "配置管理")
@RestController
@RequestMapping("/config")
public class ConfigController {
    @Resource
    //ConfigService configService;

    /**
     * 将库存中的商品ID同步到门店中，并将数量初始化为0.(未完成)
     * @param
     * @return
     */
    @ApiOperation("商品列表初始化")
    @PostMapping("/initialization")
    public Result initialization(){
        return Result.success();
    }
}
