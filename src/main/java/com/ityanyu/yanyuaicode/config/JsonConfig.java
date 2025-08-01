/**
 * @projectName yanyu-ai-code
 * @package com.ityanyu.yanyuaicode.config
 * @className com.ityanyu.yanyuaicode.config.JsonConfig
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ityanyu.yanyuaicode.config;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;


/**
 * JsonConfig
 * @description 解决精度丢失问题  Spring MVC Json 配置
 * @author dengling
 * @date 2025/8/1 17:46
 * @version 1.0
 */

@JsonComponent
public class JsonConfig {

    /**
     * 添加 Long 转 json 精度丢失的配置
     */
    @Bean
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Long.class, ToStringSerializer.instance);
        module.addSerializer(Long.TYPE, ToStringSerializer.instance);
        objectMapper.registerModule(module);
        return objectMapper;
    }
}

