package com.ityanyu.yanyuaicode.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

/**
 * ImageCollectionService
 * @description 图片收集 AI 服务接口，调用 AI 收集不同类型的图片资源
 * @author dengling
 * @date 2025/9/10 15:28
 * @version 1.0
 */
public interface ImageCollectionService {

    /**
     * 根据用户提示词收集所需的图片资源
     * AI 会根据需求自主选择调用相应的工具
     */
    @SystemMessage(fromResource = "prompt/image-collection-system-prompt.txt")
    String collectImages(@UserMessage String userPrompt);
}

