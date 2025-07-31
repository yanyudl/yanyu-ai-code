package com.ityanyu.yanyuaicode.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: dl
 * @Date: 2025/7/30
 * @Description: 删除请求包装类
 **/
@Data
public class DeleteRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}

