package com.ityanyu.yanyuaicode.model.dto.app;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: dl
 * @Date: 2025/8/17
 * @Description: 用户更新应用请求
 **/
@Data
public class AppUpdateRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 应用名称
     */
    private String appName;

    private static final long serialVersionUID = 1L;
}
