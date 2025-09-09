package com.ityanyu.yanyuaicode.langgraph4j.model;

import java.io.Serial;
import java.io.Serializable;

import com.ityanyu.yanyuaicode.langgraph4j.enums.ImageCategoryEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ImageResource
 * @description 图片资源对象
 * @author dengling
 * @date 2025/9/9 16:20
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageResource implements Serializable {

    /**
     * 图片类别
     */
    private ImageCategoryEnum category;

    /**
     * 图片描述
     */
    private String description;

    /**
     * 图片地址
     */
    private String url;

    @Serial
    private static final long serialVersionUID = 1L;
}

