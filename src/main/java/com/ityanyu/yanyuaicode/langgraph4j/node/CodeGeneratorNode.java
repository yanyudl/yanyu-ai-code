package com.ityanyu.yanyuaicode.langgraph4j.node;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.bsc.langgraph4j.action.AsyncNodeAction;
import org.bsc.langgraph4j.prebuilt.MessagesState;

import com.ityanyu.yanyuaicode.constant.AppConstant;
import com.ityanyu.yanyuaicode.core.AiCodeGeneratorFacade;
import com.ityanyu.yanyuaicode.langgraph4j.model.ImageResource;
import com.ityanyu.yanyuaicode.langgraph4j.state.WorkflowContext;
import com.ityanyu.yanyuaicode.model.enums.CodeGenTypeEnum;
import com.ityanyu.yanyuaicode.utils.SpringContextUtil;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import static org.bsc.langgraph4j.action.AsyncNodeAction.node_async;

/**
 * CodeGeneratorNode
 * @description 代码生成节点
 * @author dengling
 * @date 2025/9/9 16:41
 * @version 1.0
 */
@Slf4j
public class CodeGeneratorNode {
    public static AsyncNodeAction<MessagesState<String>> create() {
        return node_async(state -> {
            WorkflowContext context = WorkflowContext.getContext(state);
            log.info("执行节点: 代码生成");

            // 使用增强提示词作为发给 AI 的用户消息
            String userMessage = context.getEnhancedPrompt();
            CodeGenTypeEnum generationType = context.getGenerationType();
            // 获取 AI 代码生成外观服务
            AiCodeGeneratorFacade codeGeneratorFacade = SpringContextUtil.getBean(AiCodeGeneratorFacade.class);
            log.info("开始生成代码，类型: {} ({})", generationType.getValue(), generationType.getText());
            // 先使用固定的 appId (后续再整合到业务中)
            Long appId = 0L;
            // 调用流式代码生成
            Flux<String> codeStream = codeGeneratorFacade.generateAndSaveCodeStream(userMessage, generationType, appId);
            // 同步等待流式输出完成
            codeStream.blockLast(Duration.ofMinutes(10)); // 最多等待 10 分钟
            // 根据类型设置生成目录
            String generatedCodeDir = String.format("%s/%s_%s", AppConstant.CODE_OUTPUT_ROOT_DIR, generationType.getValue(), appId);
            log.info("AI 代码生成完成，生成目录: {}", generatedCodeDir);

            // 更新状态
            context.setCurrentStep("代码生成");
            context.setGeneratedCodeDir(generatedCodeDir);
            return WorkflowContext.saveContext(context);
        });
    }
}
