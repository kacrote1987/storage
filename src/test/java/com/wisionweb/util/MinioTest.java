package com.wisionweb.util;

import io.minio.MinioClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 张亚强
 * @date 2024/8/12 11:22 AM
 * @Description TODO
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MinioTest {

    @Resource
    MinioUtil minioUtil;
    @Test
    public void test(){
        boolean exist = minioUtil.bucketExists("test");
        System.out.println(exist);
    }
}
