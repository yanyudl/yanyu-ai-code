package com.ityanyu.yanyuaicode.langgraph4j.tool;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ityanyu.yanyuaicode.langgraph4j.enums.ImageCategoryEnum;
import com.ityanyu.yanyuaicode.langgraph4j.model.ImageResource;

import jakarta.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ImageSearchToolTest {

    @Resource
    private ImageSearchTool imageSearchTool;

    @Test
    void testSearchContentImages() {
        // 测试正常搜索
        List<ImageResource> images = imageSearchTool.searchContentImages("World Cup");
        assertNotNull(images);
        assertFalse(images.isEmpty());
        // 验证返回的图片资源
        ImageResource firstImage = images.get(0);
        assertEquals(ImageCategoryEnum.CONTENT, firstImage.getCategory());
        assertNotNull(firstImage.getDescription());
        assertNotNull(firstImage.getUrl());
        assertTrue(firstImage.getUrl().startsWith("http"));
        System.out.println("搜索到 " + images.size() + " 张图片");
        images.forEach(image ->
                System.out.println("图片: " + image.getDescription() + " - " + image.getUrl())
        );
    }
}

