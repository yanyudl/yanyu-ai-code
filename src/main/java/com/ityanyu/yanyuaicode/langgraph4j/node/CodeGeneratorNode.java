package com.ityanyu.yanyuaicode.langgraph4j.node;

import org.bsc.langgraph4j.action.AsyncNodeAction;
import org.bsc.langgraph4j.prebuilt.MessagesState;

import com.ityanyu.yanyuaicode.langgraph4j.state.WorkflowContext;

import lombok.extern.slf4j.Slf4j;

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

            // TODO: 实际执行代码生成逻辑

            // 简单的假数据
            String generatedCodeDir = "/tmp/generated/fake-code";
            // 更新状态
            context.setCurrentStep("代码生成");
            context.setGeneratedCodeDir(generatedCodeDir);
            log.info("代码生成完成，目录: {}", generatedCodeDir);
            return WorkflowContext.saveContext(context);
        });
    }
}

