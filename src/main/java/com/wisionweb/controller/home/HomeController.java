package com.wisionweb.controller.home;

import com.wisionweb.entity.InfoDetForm;
import com.wisionweb.entity.NoticeDetForm;
import com.wisionweb.entity.NoticeListForm;
import com.wisionweb.service.HomeService;
import com.wisionweb.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "首页")
@RestController
@RequestMapping("/home")
public class HomeController {
    @Resource
    HomeService homeService;

    @ApiOperation("首页列表111")
    @PostMapping("/homeList")
    public Result noticeList(){
        List<NoticeListForm> noticeList= homeService.noticeList(1L);
        return Result.success(noticeList);
    }

    @ApiOperation("新闻资讯列表")
    @PostMapping("/newsList")
    public Result newsList(){
        List<NoticeListForm> noticeList= homeService.noticeList(2L);
        return Result.success(noticeList);
    }

    @ApiOperation("产品中心列表")
    @PostMapping("/prodList")
    public Result prodList(){
        List<NoticeListForm> noticeList= homeService.noticeList(3L);
        return Result.success(noticeList);
    }

    @ApiOperation("解决方案列表")
    @PostMapping("/solutionList")
    public Result solutionList(){
        List<NoticeListForm> noticeList= homeService.noticeList(4L);
        return Result.success(noticeList);
    }

    @ApiOperation("服务与支持列表")
    @PostMapping("/supportList")
    public Result supportList(){
        List<NoticeListForm> noticeList= homeService.noticeList(5L);
        return Result.success(noticeList);
    }

    @ApiOperation("通知详情")
    @PostMapping("/noticeDet")
    public Result noticeDet(Long typeId, Long noticeId){
        NoticeDetForm noticeDet= homeService.noticeDet(typeId,noticeId);
        return Result.success(noticeDet);
    }

    @ApiOperation("关于我们")
    @PostMapping("/infoDet")
    public Result infoDet(){
        InfoDetForm infoDet= homeService.infoDet();
        return Result.success(infoDet);
    }
}
