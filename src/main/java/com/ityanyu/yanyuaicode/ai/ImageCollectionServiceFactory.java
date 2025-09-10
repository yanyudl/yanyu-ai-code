package com.ityanyu.yanyuaicode.ai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ityanyu.yanyuaicode.langgraph4j.tool.ImageSearchTool;
import com.ityanyu.yanyuaicode.langgraph4j.tool.LogoGeneratorTool;
import com.ityanyu.yanyuaicode.langgraph4j.tool.MermaidDiagramTool;
import com.ityanyu.yanyuaicode.langgraph4j.tool.UndrawIllustrationTool;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

/**
 * ImageCollectionServiceFactory
 * @description AI 收集图片服务工厂类
 * @author dengling
 * @date 2025/9/10 15:32
 * @version 1.0
 */
@Slf4j
@Configuration
public class ImageCollectionServiceFactory {

    @Resource
    private ChatModel chatModel;

    @Resource
    private ImageSearchTool imageSearchTool;

    @Resource
    private UndrawIllustrationTool undrawIllustrationTool;

    @Resource
    private MermaidDiagramTool mermaidDiagramTool;

    @Resource
    private LogoGeneratorTool logoGeneratorTool;

    /**
     * 创建图片收集 AI 服务
     */
    @Bean
    public ImageCollectionService createImageCollectionService() {
        return AiServices.builder(ImageCollectionService.class)
                .chatModel(chatModel)
                .tools(
                        imageSearchTool,
                        undrawIllustrationTool,
                        mermaidDiagramTool,
                        logoGeneratorTool
                )
                .build();
    }
}
