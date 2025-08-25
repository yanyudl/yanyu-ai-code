package com.ityanyu.yanyuaicode.ai;

import com.ityanyu.yanyuaicode.ai.model.HtmlCodeResult;
import com.ityanyu.yanyuaicode.ai.model.MultiFileCodeResult;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import reactor.core.publisher.Flux;

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
    HtmlCodeResult generateHtmlCode(String userMessage);

    /**
     * 生成多文件代码
     *
     * @param userMessage 用户提示词
     * @return AI输出结果
     */
    @SystemMessage(fromResource = "prompt/codegen-multi-file-svstem-prompt.txt")
    MultiFileCodeResult generateMultiFileCode(String userMessage);

    /**
     * 生成 HTML 代码（流式输出）
     *
     * @param userMessage 用户提示词
     * @return AI输出结果
     */
    @SystemMessage(fromResource = "prompt/codegen-html-system-prompt.txt")
    Flux<String> generateHtmlCodeStream(String userMessage);

    /**
     * 生成多文件代码（流式输出）
     *
     * @param userMessage 用户提示词
     * @return AI输出结果
     */
    @SystemMessage(fromResource = "prompt/codegen-multi-file-svstem-prompt.txt")
    Flux<String> generateMultiFileCodeStream(String userMessage);

    /**
     * 生成 Vue 项目代码（流式）
     *
     * @param userMessage 用户消息
     * @return 生成过程的流式响应
     */
    @SystemMessage(fromResource = "prompt/codegen-vue-project-system-prompt.txt")
    Flux<String> generateVueProjectCodeStream(@MemoryId long appId, @UserMessage String userMessage);

}

