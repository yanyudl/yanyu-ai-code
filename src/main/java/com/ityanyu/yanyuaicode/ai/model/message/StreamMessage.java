package com.ityanyu.yanyuaicode.ai.model.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: dl
 * @Date: 2025/8/25
 * @Description: 流式响应消息基类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StreamMessage {
    private String type;
}
