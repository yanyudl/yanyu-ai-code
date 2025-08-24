package com.ityanyu.yanyuaicode.config;

import dev.langchain4j.community.store.memory.chat.redis.RedisChatMemoryStore;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: dl
 * @Date: 2025/8/24
 * @Description: redis 配置类
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.data.redis")
public class RedisChatMemoryStoreConfig {

    private String host;
    private int port;
    private String password;
    private int database;
    private long ttl;
    private String username;

    @Bean
    RedisChatMemoryStore redisChatMemoryStore(){
        return RedisChatMemoryStore.builder()
                .host(host)
                .port(port)
                .user(username)
                .password(password)
                .ttl(ttl)
                .build();
    }
}
