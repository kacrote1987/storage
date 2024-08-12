package com.wisionweb.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface MinioService {
    /**
     * minio上传
     * @return
     */
    String minioUpload(@RequestParam MultipartFile file);
}
