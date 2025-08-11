package com.ityanyu.yanyuaicode.ai;

import dev.langchain4j.service.SystemMessage;

/**
 * @author: dl
 * @Date: 2025/8/11
 * @Description: AI Service 开发模式
 **/
public interface AiCodeGeneratorService {

    /**
     * 生成 HTML 代码
     *
     * @param userMessage 用户提示词
     * @return AI输出结果
     */
    @SystemMessage(fromResource = "prompt/codegen-html-system-prompt.txt")
    String generateHtmlCode(String userMessage);

    /**
     * 生成多文件代码
     *
     * @param userMessage 用户提示词
     * @return AI输出结果
     */
    @SystemMessage(fromResource = "prompt/codegen-multi-file-svstem-prompt.txt")
    String generateMultiFileCode(String userMessage);
}

