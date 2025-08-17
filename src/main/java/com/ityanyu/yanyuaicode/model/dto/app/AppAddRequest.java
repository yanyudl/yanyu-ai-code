package com.ityanyu.yanyuaicode.model.dto.app;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: dl
 * @Date: 2025/8/17
 * @Description: 创建应用请求
 **/
@Data
public class AppAddRequest implements Serializable {

    /**
     * 应用初始化的 prompt
     */
    private String initPrompt;

    private static final long serialVersionUID = 1L;
}

