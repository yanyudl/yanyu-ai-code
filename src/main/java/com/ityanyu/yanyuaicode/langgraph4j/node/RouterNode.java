package com.ityanyu.yanyuaicode.langgraph4j.node;

import org.bsc.langgraph4j.action.AsyncNodeAction;
import org.bsc.langgraph4j.prebuilt.MessagesState;

import com.ityanyu.yanyuaicode.langgraph4j.state.WorkflowContext;
import com.ityanyu.yanyuaicode.model.enums.CodeGenTypeEnum;

import lombok.extern.slf4j.Slf4j;

import static org.bsc.langgraph4j.action.AsyncNodeAction.node_async;

/**
 * RouterNode
 * @description 智能路由节点
 * @author dengling
 * @date 2025/9/9 16:40
 * @version 1.0
 */
@Slf4j
public class RouterNode {
    public static AsyncNodeAction<MessagesState<String>> create() {
        return node_async(state -> {
            WorkflowContext context = WorkflowContext.getContext(state);
            log.info("执行节点: 智能路由");

            // TODO: 实际执行智能路由逻辑

            // 简单的假数据
            CodeGenTypeEnum generationType = CodeGenTypeEnum.HTML;
            // 更新状态
            context.setCurrentStep("智能路由");
            context.setGenerationType(generationType);
            log.info("路由决策完成，选择类型: {}", generationType.getText());
            return WorkflowContext.saveContext(context);
        });
    }
}

