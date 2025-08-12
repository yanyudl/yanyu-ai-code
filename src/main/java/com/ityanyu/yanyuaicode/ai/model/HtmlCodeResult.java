package com.ityanyu.yanyuaicode.ai.model;

import dev.langchain4j.model.output.structured.Description;
import lombok.Data;

/**
 * @author: dl
 * @Date: 2025/8/12
 * @Description: Html 代码结果
 **/
@Description("生成 HTML 代码文件的结果")
@Data
public class HtmlCodeResult {

    /**
     * html 代码
     */
    @Description("HTML代码")
    private String htmlCode;

    /**
     * 描述
     */
    @Description("生成代码的描述")
    private String description;
}

