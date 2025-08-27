package com.ityanyu.yanyuaicode.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: dl
 * @Date: 2025/8/27
 * @Description:
 **/
@SpringBootTest
@Slf4j
class WebScreenshotUtilsTest {

    @Test
    void saveWebPageScreenshot() {
        String url = "https://www.baidu.com";
        String filePath = WebScreenshotUtils.saveWebPageScreenshot(url);
        log.info("截图路径：{}", filePath);
    }
}