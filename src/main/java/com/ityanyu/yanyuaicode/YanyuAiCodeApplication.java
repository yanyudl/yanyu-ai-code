package com.ityanyu.yanyuaicode;

import dev.langchain4j.community.store.embedding.redis.spring.RedisEmbeddingStoreAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {RedisEmbeddingStoreAutoConfiguration.class})
@MapperScan("com.ityanyu.yanyuaicode.mapper")
public class YanyuAiCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(YanyuAiCodeApplication.class, args);
    }

}
