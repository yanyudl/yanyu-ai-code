package com.ityanyu.yanyuaicode.langgraph4j.node;

import java.util.Arrays;
import java.util.List;

import org.bsc.langgraph4j.action.AsyncNodeAction;
import org.bsc.langgraph4j.prebuilt.MessagesState;

import com.ityanyu.yanyuaicode.ai.ImageCollectionService;
import com.ityanyu.yanyuaicode.langgraph4j.enums.ImageCategoryEnum;
import com.ityanyu.yanyuaicode.langgraph4j.model.ImageResource;
import com.ityanyu.yanyuaicode.langgraph4j.state.WorkflowContext;
import com.ityanyu.yanyuaicode.utils.SpringContextUtil;

import lombok.extern.slf4j.Slf4j;

import static org.bsc.langgraph4j.action.AsyncNodeAction.node_async;

/**
 * ImageCollectorNode
 * @description 图片收集节点
 * @author dengling
 * @date 2025/9/9 16:37
 * @version 1.0
 */
@Slf4j
public class ImageCollectorNode {
    public static AsyncNodeAction<MessagesState<String>> create() {
        return node_async(state -> {
            WorkflowContext context = WorkflowContext.getContext(state);
            String originalPrompt = context.getOriginalPrompt();
            String imageListStr = "";
            try{
                // 获取 AI 图片收集服务
                ImageCollectionService imageCollectionService = SpringContextUtil.getBean(ImageCollectionService.class);
                imageListStr = imageCollectionService.collectImages(originalPrompt);
            }catch (Exception e){
                log.error("图片收集失败：{}",e.getMessage(),e);
            }

            // 更新状态
            context.setCurrentStep("图片收集");
            context.setImageListStr(imageListStr);
            return WorkflowContext.saveContext(context);
        });
    }
}
