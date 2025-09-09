package com.ityanyu.yanyuaicode.langgraph4j.node;

import org.bsc.langgraph4j.action.AsyncNodeAction;
import org.bsc.langgraph4j.prebuilt.MessagesState;

import com.ityanyu.yanyuaicode.langgraph4j.state.WorkflowContext;

import lombok.extern.slf4j.Slf4j;

import static org.bsc.langgraph4j.action.AsyncNodeAction.node_async;

/**
 * PromptEnhancerNode
 * @description 提示词增强节点
 * @author dengling
 * @date 2025/9/9 16:39
 * @version 1.0
 */
@Slf4j
public class PromptEnhancerNode {
    public static AsyncNodeAction<MessagesState<String>> create() {
        return node_async(state -> {
            WorkflowContext context = WorkflowContext.getContext(state);
            log.info("执行节点: 提示词增强");

            // TODO: 实际执行提示词增强逻辑

            // 简单的假数据
            String enhancedPrompt = "这是增强后的假数据提示词";

            // 更新状态
            context.setCurrentStep("提示词增强");
            context.setEnhancedPrompt(enhancedPrompt);
            log.info("提示词增强完成");
            return WorkflowContext.saveContext(context);
        });
    }
}

