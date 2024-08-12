package com.wisionweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//多数据源时用exclude去除默认配置
@SpringBootApplication
public class WisionWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WisionWebApplication.class, args);
    }
}
