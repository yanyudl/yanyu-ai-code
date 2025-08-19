package com.ityanyu.yanyuaicode.model.dto.app;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: dl
 * @Date: 2025/8/19
 * @Description: 部署请求类
 **/
@Data
public class AppDeployRequest implements Serializable {

    /**
     * 应用 id
     */
    private Long appId;

    private static final long serialVersionUID = 1L;
}

