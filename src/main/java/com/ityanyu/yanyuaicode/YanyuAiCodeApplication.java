package com.ityanyu.yanyuaicode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ityanyu.yanyuaicode.mapper")
public class YanyuAiCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(YanyuAiCodeApplication.class, args);
    }

}
