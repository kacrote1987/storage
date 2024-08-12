package com.wisionweb.controller.home;

import com.wisionweb.service.MinioService;
import com.wisionweb.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Api(description = "上传")
@RestController
@RequestMapping("/mimio")
public class MinioController {
    @Resource
    MinioService mimioService;

    @ApiOperation("minio上传")
    @PostMapping("/upload")
    public Result minioUpload(@RequestParam MultipartFile file){
        String url= mimioService.minioUpload(file);
        return Result.success(url);
    }
}
