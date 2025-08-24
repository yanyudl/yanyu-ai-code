package com.ityanyu.yanyuaicode.model.dto.chathistory;

import com.ityanyu.yanyuaicode.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: dl
 * @Date: 2025/8/24
 * @Description: 查询对话历史请求类，使用游标查询
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ChatHistoryQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 消息类型（user/ai）
     */
    private String messageType;

    /**
     * 应用id
     */
    private Long appId;

    /**
     * 创建用户id
     */
    private Long userId;

    /**
     * 游标查询 - 最后一条记录的创建时间
     * 用于分页查询，获取早于此时间的记录
     */
    private LocalDateTime lastCreateTime;

    private static final long serialVersionUID = 1L;
}

