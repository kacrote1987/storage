package com.wisionweb.service.impl;

import com.wisionweb.service.MinioService;
import com.wisionweb.util.MinioUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MinioServiceImpl implements MinioService {

    @Override
    public String minioUpload(@RequestParam MultipartFile file) {
        MinioUtil minioUtil = null;
//        获取上传的文件名
//        String filename = file.getOriginalFilename();
//        // 可以选择生成一个minio中存储的文件名称
//        String minioFilename = UUID.randomUUID() + "_" + filename;
//        String path = "http://10.100.14.56:9901/";
//        String url = path + minioFilename;
//
//        try {
//            minioClient.putObject("wisionweb", filename, file.getInputStream(), file.getSize(),
//                    file.getContentType());
//        } catch (MinioException e) {
//            e.printStackTrace();
//            throw new UnAuthorizationException("上传失败");
//        }
//        return url;

        String url = minioUtil.upload(file);
        return url;
    }
}
