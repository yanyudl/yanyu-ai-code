package com.ityanyu.yanyuaicode.ai;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: dl
 * @Date: 2025/8/11
 * @Description:
 **/
@SpringBootTest
class AiCodeGeneratorServiceTest {

    @Resource
    private AiCodeGeneratorService aiCodeGeneratorService;

    @Test
    void generateHtmlCode() {
        String result = aiCodeGeneratorService.generateHtmlCode("做个程序员鱼皮的工作记录小工具，不超过20行代码");
        Assertions.assertNotNull(result);
    }

    @Test
    void generateMultiFileCode() {
        String multiFileCode = aiCodeGeneratorService.generateMultiFileCode("做个程序员鱼皮的留言板，不超过50行代码");
        Assertions.assertNotNull(multiFileCode);
    }
}
