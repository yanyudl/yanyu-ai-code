package com.ityanyu.yanyuaicode.service;

import com.ityanyu.yanyuaicode.model.dto.chathistory.ChatHistoryQueryRequest;
import com.ityanyu.yanyuaicode.model.entity.User;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.ityanyu.yanyuaicode.model.entity.ChatHistory;

import java.time.LocalDateTime;

/**
 *  服务层。
 *
 * @author <a href="https://github.com/yanyu">烟雨</a>
 */
public interface ChatHistoryService extends IService<ChatHistory> {

    /**
     * 添加聊天记录
     *
     * @param appId 应用标识
     * @param message 消息内容
     * @param messageType 消息类型
     * @param userId 当前登录用户
     * @return
     */
    boolean addChatHistory(Long appId, String message, String messageType, Long userId);

    /**
     * 根据应用标识删除聊天记录
     *
     * @param appId 应用标识
     * @return
     */
    boolean deleteByAppId(Long appId);

    /**
     * 根据查询条件获取查询包装器
     *
     * @param chatHistoryQueryRequest 查询条件
     * @return
     */
    QueryWrapper getQueryWrapper(ChatHistoryQueryRequest chatHistoryQueryRequest);

    /**
     * 根据应用标识分页获取聊天记录
     * @param appId 应用标识
     * @param pageSize 每页大小
     * @param lastCreateTime 最后创建时间
     * @param loginUser 当前登录用户
     * @return
     */
    Page<ChatHistory> listAppChatHistoryByPage(Long appId, int pageSize,
                                               LocalDateTime lastCreateTime,
                                               User loginUser);
}
